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


    public ExecutionVisitor() {
        valueTable = new ValueTable<>();
        methodTable = new MethodTable();
        structureTable = new ValueTable<>();
    }

    @Override
    public Object visit(ClassNode classNode, Object data) {
        for (ProcedureNode procedureNode : classNode.getProcedures())
            methodTable.addMethod(procedureNode.getHeadingNode().getName(), procedureNode);

        return visit(classNode.getSequentialProcedureNode(), data);
    }

    @Override
    public Object visit(RegularRuleNode ruleNode, Object data) {
        List<AskNode> asks = ruleNode.getAsks();
        List<TellNode> tells = ruleNode.getTells();

        for (AskNode askNode : asks) {
            String result = (String) visit(askNode, data);
            if (!Boolean.parseBoolean(result))
                return null;
        }

        // In the context of a tell, the equals symbol behaves differently, so we must change the semantics
        data = Flag.ASSIGN;
        String result = null;
        for (TellNode tellNode : tells)
            result = (String) visit(tellNode, data);
        return result;
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, Object data) {
        data = Flag.ASSIGN;
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
        visit(procedureNode.getHeadingNode(), data);
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
    public Object visit(SequentialProcedureNode sequentialProcedureNode, Object data) {
        valueTable.enterScope();
        structureTable.enterScope();
        data = Flag.ASSIGN;
        visit(sequentialProcedureNode.getHeadingNode(), data);
        Object body = visit(sequentialProcedureNode.getSequentialBody(), data);
        valueTable.exitScope();
        structureTable.exitScope();
        return body;
    }

    @Override
    public Object visit(SequentialBodyNode sequentialBodyNode, Object data) {
        String lastExpressionEvaluated = null;
        for (ExpressionNode expressionNode : sequentialBodyNode.getExpressions())
            lastExpressionEvaluated = (String) visit(expressionNode, data);
        return lastExpressionEvaluated;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visit(RuleSetNode ruleSetNode, Object data) {
        List<WriterNode> writers = (List<WriterNode>) data;
        String lastWriterVariable = writers.get(writers.size() - 1).getName();

        String resultingValue = null;

        int numRules = ruleSetNode.getRegularRules().size();

        ExecutorService executorService = Executors.newFixedThreadPool(numRules);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        List<RegularRuleNode> ruleNodes = new ArrayList<>(ruleSetNode.getRegularRules());
        Collections.shuffle(ruleNodes);

        for (RegularRuleNode regularRuleNode : ruleNodes)
            completionService.submit(() -> (String) visit(regularRuleNode, data));

        int receivedCount = 0;

        while (!executorService.isTerminated() && receivedCount < numRules) {
            try {
                Future<String> resultFuture = completionService.take();
                String resultNode = resultFuture.get();
                if (resultNode != null) {
                    executorService.shutdownNow();
                    resultingValue = (String) valueTable.findInScope(lastWriterVariable);
                }
                receivedCount++;
            } catch (InterruptedException ignored) {
                // We want to interrupt computation that is occurring if we already received a result!
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        if (!executorService.isTerminated())
            executorService.shutdownNow();

        // Null if no rule applicable, so final rule can apply
        return resultingValue;
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

                Object paramValue = valueTable.findInScope(param);

                if (paramValue == null)
                    paramValue = param;

                valueTable.addVariable(formalName, paramValue);

                if(structureTable.findInScope(param) != null)
                    structureTable.addVariable(formalName, structureTable.findInScope(param));
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
    public Object visit(EqNode eqNode, Object data) {

        // Depending on the flag, EqNode can imply a comparison or an assignment
        if (data == Flag.ASSIGN) {
            String left = (String) visit(eqNode.getLeft(), Flag.ID_ONLY);
            String right = (String) visit(eqNode.getRight(), data);
            valueTable.addVariable(left, right);
            return left;
        } else {
            String left = (String) visit(eqNode.getLeft(), data);
            String right = (String) visit(eqNode.getRight(), data);
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
        for (ExpressionNode expr : structureNode.getValues())
            actualValues.add((String) visit(expr, data));

        if (data == Flag.ASSIGN) {

            // TODO decide if comparing string representations of structure name + values is ideal or not
            String representation = structureNode.getStructureName() + actualValues.toString();

            valueTable.addVariable(structureNode.getVarName(), representation);
            structureTable.addVariable(structureNode.getVarName(), new Structure(structureNode.getStructureName(), structureNode.getVarName(), actualValues));
            return representation;
        } else {
            // Alias variables when you visit a structure node in a comparison sense
            Structure existingStructure = structureTable.findInScope(structureNode.getVarName());

            if(existingStructure == null || existingStructure.getValues().size() != structureNode.getValues().size())
                return Boolean.toString(false);

            List<String> retrievedActuals = existingStructure.getValues();

            for (int i = 0; i<structureNode.getValues().size(); i++) {
                ExpressionNode expr = structureNode.getValues().get(i);

                String variableName = (String) visit(expr, data);
                valueTable.addVariable(variableName, retrievedActuals.get(i));
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
        // Done differently to allow dynamic dispatch TODO investigate
        return expressionNode.accept(this, data);
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
    public Object visit(BooleanNode booleanNode, Object data) {
        return booleanNode.getNodeValue();
    }

    @Override
    public Object visit(IdentifierNode identifierNode, Object data) {
        String identifierNodeValue = identifierNode.getNodeValue();
        if (valueTable.findInScope(identifierNodeValue) == null || data == Flag.ID_ONLY)
            return identifierNodeValue;
        return valueTable.findInScope(identifierNodeValue);
    }


    @Override
    public Object visit(IntegerNode integerNode, Object data) {
        return Integer.toString(integerNode.getNodeValue());
    }

    @Override
    public Object visit(StringConstNode stringConstNode, Object data) {
        return stringConstNode.getNodeValue();
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
