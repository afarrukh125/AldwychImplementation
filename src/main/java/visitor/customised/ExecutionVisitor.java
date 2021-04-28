package visitor.customised;

import helpers.Flag;
import helpers.MethodTable;
import helpers.Structure;
import helpers.ValueTable;
import nodes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExecutionVisitor implements CustomVisitor<Object, Object> {

    private final ValueTable<String, Object> valueTable;
    private final ValueTable<String, Structure> structureTable;
    private final MethodTable methodTable;

    public static final String STRUCTURE_IDENTIFIER = "\0";

    public ExecutionVisitor() {
        valueTable = new ValueTable<>();
        methodTable = new MethodTable();
        structureTable = new ValueTable<>();
    }

    @Override
    public Object visit(ClassNode classNode, Object data) {
        for (ProcedureNode procedureNode : classNode.getProcedures())
            methodTable.addMethod(procedureNode.getHeadingNode().getName(), procedureNode);

        return visit(classNode.getMainProcedureNode(), data);
    }

    @Override
    public Object visit(RegularRuleNode ruleNode, Object data) {
        List<AskNode> asks = ruleNode.getAsks();
        for (AskNode askNode : asks) {
            String result = (String) visit(askNode, data);
            if (!Boolean.parseBoolean(result))
                return null;
        }
        return ruleNode;
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, Object data) {
        data = Flag.EQ_SET;
        String result = null;
        for (TellNode tellNode : finalRuleNode.getTells())
            result = (String) visit(tellNode, data);
        return result;
    }

    @Override
    public Object visit(AskNode askNode, Object data) {
        return visit(askNode.getExpressionNode(), data);
    }

    @Override
    public Object visit(ProcedureNode procedureNode, Object data) {
        return visit(procedureNode.getBody(), procedureNode.getHeadingNode().getWriters().getWriterNodes());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visit(BodyNode bodyNode, Object data) {
        List<WriterNode> writers = (List<WriterNode>) data;
        String lastWriterVariable = writers.get(writers.size() - 1).getName();

        String resultingValue;

        for (RuleSetNode ruleSet : bodyNode.getRulesets()) {
            resultingValue = (String) visit(ruleSet, data);
            if (resultingValue != null)
                return resultingValue;
        }

        visit(bodyNode.getFinalRule(), data);
        return valueTable.findInScope(lastWriterVariable);
    }

    @Override
    public Object visit(MainProcedureNode mainProcedureNode, Object data) {
        valueTable.enterScope();
        structureTable.enterScope();
        data = Flag.EQ_SET;
        Object body = visit(mainProcedureNode.getFinalRuleNode(), data);
        valueTable.exitScope();
        structureTable.exitScope();
        return body;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visit(RuleSetNode ruleSetNode, Object data) {
        List<WriterNode> writers = (List<WriterNode>) data;
        String lastWriterVariable = writers.get(writers.size() - 1).getName();

        int numRules = ruleSetNode.getRegularRules().size();

        ExecutorService executorService = Executors.newFixedThreadPool(numRules);
        CompletionService<RegularRuleNode> completionService = new ExecutorCompletionService<>(executorService);

        List<RegularRuleNode> ruleNodes = new ArrayList<>(ruleSetNode.getRegularRules());
        Collections.shuffle(ruleNodes);

        // We run all the rules concurrently - and the choice is made based on the scheduling of the threads
        // Now, the rule that returns first, and returns successfully, is the one whose tell is run, i.e. it becomes empty

        // It was done this way because multiple dispatches occurring at the same time caused problems to shared variables
        for (RegularRuleNode regularRuleNode : ruleNodes) {
            Object finalData = data;
            completionService.submit(() -> (RegularRuleNode) visit(regularRuleNode, finalData));
        }

        RegularRuleNode resultNode = null;

        int receivedCount = 0;

        while (!executorService.isTerminated() && receivedCount < numRules) {
            try {
                Future<RegularRuleNode> resultFuture = completionService.take();
                resultNode = resultFuture.get();
                if (resultNode != null) {
                    executorService.shutdownNow();
                    break;
                }
                receivedCount++;
            } catch (InterruptedException ignored) {
                // We want to interrupt computation that is occurring if we already received a result!
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        if(resultNode != null) {
            List<TellNode> tells = resultNode.getTells();

            // In the context of a tell, the equals symbol behaves differently, so we must change the semantics
            data = Flag.EQ_SET;
            for (TellNode tellNode : tells)
                visit(tellNode, data);
        }

        if (!executorService.isTerminated())
            executorService.shutdownNow();

        // Null if no rule applicable, so final rule can apply
        return valueTable.findInScope(lastWriterVariable);
    }

    @Override
    public Object visit(DispatchNode dispatchNode, Object data) {

        String procedureName = dispatchNode.getName();

        if (methodTable.canHandle(procedureName)) {
            List<String> dispatchParams = new ArrayList<>();

            for (ExpressionNode expressionNode : dispatchNode.getParams()) {
                Object result = visit(expressionNode, data);
                dispatchParams.add((String) result);
            }

            return methodTable.handleDefaultMethod(procedureName, dispatchParams);
        } else {
            Subroutine procedureNode = methodTable.getMethodByName(procedureName);

            List<String> formalParameters = procedureNode.getHeadingNode().getReaders().getReaderNodes()
                    .stream()
                    .map(ReaderNode::getName)
                    .collect(Collectors.toList());

            List<String> dispatchParams = new ArrayList<>();
            for (ExpressionNode exp : dispatchNode.getParams()) {
                String rawPara = (String) visit(exp, Flag.ID_ONLY);

                if(structureTable.findInScope(rawPara) != null) {
                    structureTable.addVariable(rawPara, structureTable.findInScope(rawPara));
                    dispatchParams.add(rawPara);
                } else {
                    Object dispatchParam = visit(exp, data);
                    dispatchParams.add((String) dispatchParam);
                }
            }

            valueTable.enterScope();
            structureTable.enterScope();
            for (int i = 0; i < dispatchParams.size(); i++) {
                // The name of the variable as it is known in the context of the procedure
                // e.g. a b c in #p(a, b, c)
                String formalName = formalParameters.get(i);

                // e.g. x y z in meth(x, y, z) - the actual dispatch call
                String param = dispatchParams.get(i);

                String paramValue = (String) valueTable.findInScope(param);

                if (paramValue == null)
                    paramValue = param;

                // If the parameter refers to a structure in the nearest scope then...
                if(structureTable.findInScope(param) != null) {
                    Structure found = structureTable.findInScope(param);
                    valueTable.addVariable(formalName, paramValue);
                    structureTable.addVariable(formalName, found);
                }
                else
                    valueTable.addVariable(formalName, paramValue);

            }

            Object result = procedureNode.accept(this, data);

            valueTable.exitScope();
            structureTable.exitScope();

            if (dispatchNode.getWriter() != null)
                valueTable.addVariable(dispatchNode.getWriter(), result);
            return result;
        }
    }

    @Override
    public Object visit(DivNode divNode, Object data) {
        int left = parseIntegerOperand(divNode.getLeft(), data);
        int right = parseIntegerOperand(divNode.getRight(), data);

        return Integer.toString(left / right);
    }

    @Override
    public Object visit(DoubleEqualsNode doubleEqualsNode, Object data) {
        String left = (String) visit(doubleEqualsNode.getLeft(), data);
        String right = (String) visit(doubleEqualsNode.getRight(), data);

        if(left == null || right == null)
            return Boolean.toString(false);

        return Boolean.toString(left.equals(right));
    }

    @Override
    public Object visit(AssignNode assignNode, Object data) {
        String left = (String) visit(assignNode.getLeft(), Flag.ID_ONLY);
        String right = (String) visit(assignNode.getRight(), data);
        valueTable.addVariable(left, right);
        return left;
    }

    @Override
    public Object visit(EqNode eqNode, Object data) {

        // a=b in the context of an ask checks whether variable a is set to the string b.
        // a=b in the context of of a tell assigns the variable a to the string b

        // To assign and compare explicit values, the <- and == symbols are used respectively

        // Depending on the flag, EqNode can imply a comparison or an assignment

        // Structures are handled differently in the context of an equals sign if the structure is converted from an array
        if(eqNode.getRight() instanceof StructureNode) {
            StructureNode right = (StructureNode) eqNode.getRight();
            right.setVarName((String) visit(eqNode.getLeft(), data));
            Object result = visit(right, data);
            return result;
        }

        if (data == Flag.EQ_SET) {
                String left = (String) visit(eqNode.getLeft(), Flag.ID_ONLY);
                String right = (String) visit(eqNode.getRight(), Flag.ID_ONLY);
                valueTable.addVariable(left, right);
                return left;
            } else {
                String left = (String) visit(eqNode.getLeft(), null);
                String right = (String) visit(eqNode.getRight(), null);

                if(left == null || right == null)
                    return Boolean.toString(false);

                return Boolean.toString(left.equals(right));
            }
    }


    @Override
    public Object visit(GEqNode gEqNode, Object data) {
        int left = parseIntegerOperand(gEqNode.getLeft(), data);
        int right = parseIntegerOperand(gEqNode.getRight(), data);

        return Boolean.toString(left >= right);
    }

    @Override
    public Object visit(GTNode gtNode, Object data) {
        int left = parseIntegerOperand(gtNode.getLeft(), data);
        int right = parseIntegerOperand(gtNode.getRight(), data);

        return Boolean.toString(left > right);
    }

    @Override
    public Object visit(HeadingNode headingNode, Object data) {
        visit(headingNode.getReaders(), data);
        visit(headingNode.getWriters(), data);
        return null;
    }

    @Override
    public Object visit(LEqNode lEqNode, Object data) {
        int left = parseIntegerOperand(lEqNode.getLeft(), data);
        int right = parseIntegerOperand(lEqNode.getRight(), data);

        return Boolean.toString(left <= right);
    }

    @Override
    public Object visit(NEqNode nEqNode, Object data) {
        String left = (String) visit(nEqNode.getLeft(), data);
        String right = (String) visit(nEqNode.getRight(), data);

        if(left == null || right == null)
            return Boolean.toString(false);

        return Boolean.toString(left.equals(right));
    }

    @Override
    public Object visit(LTNode ltNode, Object data) {
        int left = parseIntegerOperand(ltNode.getLeft(), data);
        int right = parseIntegerOperand(ltNode.getRight(), data);

        return Boolean.toString(left < right);
    }

    @Override
    public Object visit(MulNode mulNode, Object data) {
        int left = parseIntegerOperand(mulNode.getLeft(), data);
        int right = parseIntegerOperand(mulNode.getRight(), data);

        return Integer.toString(left * right);
    }

    @Override
    public Object visit(PlusNode plusNode, Object data) {
        int left = parseIntegerOperand(plusNode.getLeft(), data);
        int right = parseIntegerOperand(plusNode.getRight(), data);

        return Integer.toString(left + right);
    }


    @Override
    public Object visit(ReaderContainerNode readerContainerNode, Object data) {
        String lastReaderName = null;
        for (ReaderNode readerNode : readerContainerNode.getReaderNodes())
            lastReaderName = (String) visit(readerNode, data);
        return lastReaderName;
    }

    @Override
    public Object visit(WriterContainerNode writerContainerNode, Object data) {
        String lastWriterNode = null;
        for (WriterNode readerNode : writerContainerNode.getWriterNodes())
            lastWriterNode = (String) visit(readerNode, data);
        return lastWriterNode;
    }


    @Override
    public Object visit(StructureNode structureNode, Object data) {
        List<String> actualValues = new ArrayList<>();
        for (ExpressionNode expr : structureNode.getExpressions())
            actualValues.add((String) visit(expr, data));

        // If we are setting a variable to refer to a structure...
        if (data == Flag.EQ_SET) {
            // TODO decide if comparing string representations of structure name + values is ideal or not
            String representation = structureNode.getVarName() + STRUCTURE_IDENTIFIER;

            valueTable.addVariable(structureNode.getVarName(), representation);
            structureTable.addVariable(structureNode.getVarName(), new Structure(structureNode.getStructureName(), structureNode.getVarName(), actualValues));
            return structureNode.getVarName();
        } else {
            // Alias variables when you visit a structure node in a comparison sense
            Structure existingStructure = structureTable.findInScope(structureNode.getVarName());

            if(existingStructure == null || existingStructure.getValues().size() != structureNode.getExpressions().size())
                return Boolean.toString(false);

            List<String> retrievedActuals = existingStructure.getValues();

            for (int i = 0; i<structureNode.getExpressions().size(); i++) {
                ExpressionNode expr = structureNode.getExpressions().get(i);

                String variableName = (String) visit(expr, Flag.ID_ONLY);

                // If we are simply comparing structures then we need to alias the parameters if they were formerly
                // known to hold other structures
                // For example, if we have the test t=two(4, v1), then we need to alias v1
                // with the second parameter of the structure that is referred to by t
                String retrievedActual = retrievedActuals.get(i);
                String retrievedActualValue = (String) valueTable.findInScope(retrievedActual);
                if(retrievedActual.contains(STRUCTURE_IDENTIFIER) || (retrievedActualValue != null && retrievedActualValue.contains(STRUCTURE_IDENTIFIER))) {
                    String originalVariableName = retrievedActuals.get(i).replace(STRUCTURE_IDENTIFIER, "");
                    Structure aliasedStructure = structureTable.findInScope(originalVariableName);

                    // Map the found structure to the variable (this is where the aliasing actually happens between v1 and the original value)
                    Structure newStructure = new Structure(aliasedStructure.getStructureName(), variableName, aliasedStructure.getValues());
                    structureTable.addVariable(variableName, newStructure);
                    valueTable.addVariable(variableName+STRUCTURE_IDENTIFIER, retrievedActual);
                } else
                    valueTable.addVariable(variableName, retrievedActual);
            }

            return Boolean.toString(existingStructure.getStructureName().equals(structureNode.getStructureName())
                    && actualValues.size() == retrievedActuals.size());
        }
    }

    @Override
    public Object visit(ReaderNode readerNode, Object data) {
        return readerNode.getName();
    }

    @Override
    public Object visit(ExpressionNode expressionNode, Object data) {
        return expressionNode.accept(this, data);
    }

    @Override
    public Object visit(ListEndNode listEndNode, Object data) {
        return "listEnd";
    }

    @Override
    public Object visit(SubNode subNode, Object data) {
        int left = parseIntegerOperand(subNode.getLeft(), data);
        int right = parseIntegerOperand(subNode.getRight(), data);

        return Integer.toString(left - right);
    }

    @Override
    public Object visit(TellNode tellNode, Object data) {
        return visit(tellNode.getExpressionNode(), data);
    }

    @Override
    public Object visit(WriterNode writerNode, Object data) {
        return writerNode.getName();
    }


    @Override
    public Object visit(IdentifierNode identifierNode, Object data) {
        String identifierNodeValue = identifierNode.getNodeValue();
        if(data == Flag.ID_ONLY)
            return identifierNodeValue;

        Object result = valueTable.findInScope(identifierNodeValue);
        if (result == null)
            return identifierNodeValue;
        return result;
    }

    @Override
    public Object visit(IntegerNode integerNode, Object data) {
        return Integer.toString(integerNode.getNodeValue());
    }

    private <T extends ExpressionNode> int parseIntegerOperand(T operand, Object data) {
        String parsedOperand = (String) visit(operand, data);
        try {
            return Integer.parseInt(parsedOperand);
        } catch (NumberFormatException e) {
            return Integer.parseInt((String) valueTable.findInScope(parsedOperand));
        }
    }
}
