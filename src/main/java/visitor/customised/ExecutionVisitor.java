package visitor.customised;

import helpers.*;
import nodes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExecutionVisitor implements CustomVisitor<Object, ExecutionEnvironment> {


    private final String STRUCTURE_IDENTIFIER = "\u0000";

    public ExecutionVisitor() {

    }

    @Override
    public Object visit(ClassNode classNode, ExecutionEnvironment env) {
        for (ProcedureNode procedureNode : classNode.getProcedures())
            env.getMethodTable().addMethod(procedureNode.getHeadingNode().getName(), procedureNode);

        return visit(classNode.getSequentialProcedureNode(), env);
    }

    @Override
    public Object visit(RegularRuleNode ruleNode, ExecutionEnvironment env) {
        List<AskNode> asks = ruleNode.getAsks();
        List<TellNode> tells = ruleNode.getTells();

        for (AskNode askNode : asks) {
            String result = (String) visit(askNode, env.copy());
            if (!Boolean.parseBoolean(result))
                return null;
        }

        // In the context of a tell, the equals symbol behaves differently, so we must change the semantics
        env.addFlag(Flag.ASSIGN);
        String result = null;
        for (TellNode tellNode : tells)
            result = (String) visit(tellNode, env.copy());
        return result;
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, ExecutionEnvironment env) {
        env.addFlag(Flag.ASSIGN);
        String result = null;
        for (TellNode tellNode : finalRuleNode.getTells())
            result = (String) visit(tellNode, env.copy());
        return result;
    }

    @Override
    public Object visit(AskNode askNode, ExecutionEnvironment env) {
        return visit(askNode.getExpressionNode(), env);
    }

    @Override
    public Object visit(ProcedureNode procedureNode, ExecutionEnvironment env) {
        visit(procedureNode.getHeadingNode(), env);
        env.addWriters(procedureNode.getHeadingNode().getWriters().getWriterNodes());
        return visit(procedureNode.getBody(), env);
    }

    @Override
    public Object visit(BodyNode bodyNode, ExecutionEnvironment env) {
        List<WriterNode> writers = env.getWriterNodes();
        String lastWriterVariable = writers.get(writers.size() - 1).getName();

        String resultingValue;

        for (RuleSetNode ruleSet : bodyNode.getRulesets()) {
            resultingValue = (String) visit(ruleSet, env);
            if (resultingValue != null)
                return resultingValue;
        }

        visit(bodyNode.getFinalRule(), env);
        return env.getValueTable().findInScope(lastWriterVariable);
    }

    @Override
    public Object visit(SequentialProcedureNode sequentialProcedureNode, ExecutionEnvironment env) {
        env.getValueTable().enterScope();
        env.getStructureTable().enterScope();
        env.addFlag(Flag.ASSIGN);
        visit(sequentialProcedureNode.getHeadingNode(), env);
        Object body = visit(sequentialProcedureNode.getSequentialBody(), env.copy());
        env.getValueTable().exitScope();
        env.getStructureTable().exitScope();
        return body;
    }

    @Override
    public Object visit(SequentialBodyNode sequentialBodyNode, ExecutionEnvironment env) {
        String lastExpressionEvaluated = null;
        for (ExpressionNode expressionNode : sequentialBodyNode.getExpressions())
            lastExpressionEvaluated = (String) visit(expressionNode, env);
        return lastExpressionEvaluated;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visit(RuleSetNode ruleSetNode, ExecutionEnvironment env) {
        List<WriterNode> writers = env.getWriterNodes();
        String lastWriterVariable = writers.get(writers.size() - 1).getName();

        String resultingValue = null;

        int numRules = ruleSetNode.getRegularRules().size();

        ExecutorService executorService = Executors.newFixedThreadPool(numRules);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        List<RegularRuleNode> ruleNodes = new ArrayList<>(ruleSetNode.getRegularRules());
        Collections.shuffle(ruleNodes);

        for (RegularRuleNode regularRuleNode : ruleNodes)
            completionService.submit(() -> (String) visit(regularRuleNode, env));

        int receivedCount = 0;

        while (!executorService.isTerminated() && receivedCount < numRules) {
            try {
                Future<String> resultFuture = completionService.take();
                String resultNode = resultFuture.get();
                if (resultNode != null) {
                    executorService.shutdownNow();
                    resultingValue = (String) env.getValueTable().findInScope(lastWriterVariable);
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
    public Object visit(DispatchNode dispatchNode, ExecutionEnvironment env) {

        String procedureName = dispatchNode.getName();

        if (env.getMethodTable().canHandle(procedureName)) {
            List<String> dispatchParams = new ArrayList<>();

            for (ExpressionNode expressionNode : dispatchNode.getParams()) {
                Object result = visit(expressionNode, env);
                dispatchParams.add((String) result);
            }

            return env.getMethodTable().handleDefaultMethod(procedureName, dispatchParams);
        } else {
            Subroutine procedureNode = env.getMethodTable().getMethodByName(procedureName);

            List<String> formalParameters = procedureNode.getHeadingNode().getReaders().getReaderNodes()
                    .stream()
                    .map(ReaderNode::getName)
                    .collect(Collectors.toList());

            List<String> dispatchParams = new ArrayList<>();
            for (ExpressionNode exp : dispatchNode.getParams()) {
                ExecutionEnvironment newEnv = env.copy();
                newEnv.addFlag(Flag.ID_ONLY);
                String rawPara = (String) visit(exp, newEnv);

                ValueTable<String, Structure> structureTable = newEnv.getStructureTable();

                if(newEnv.getValueTable().findInScope(rawPara) != null) {
                    structureTable.addVariable(rawPara, structureTable.findInScope(rawPara));
                    dispatchParams.add(rawPara);
                } else {

                    Object dispatchParam = visit(exp, env);
                    dispatchParams.add((String) dispatchParam);
                }
            }

            env.getValueTable().enterScope();
            env.getStructureTable().enterScope();
            for (int i = 0; i < dispatchParams.size(); i++) {
                // The name of the variable as it is known in the context of the procedure
                // e.g. a b c in #p(a, b, c)
                String formalName = formalParameters.get(i);
                ValueTable<String, Object> valueTable = env.getValueTable();
                ValueTable<String, Structure> structureTable = env.getStructureTable();

                // e.g. x y z in meth(x, y, z) - the actual dispatch call
                String param = dispatchParams.get(i);

                String paramValue = (String) valueTable.findInScope(param);

                if (paramValue == null)
                    paramValue = param;

                valueTable.addVariable(formalName, paramValue);

                if(structureTable.findInScope(param) != null) {
                    Structure found = structureTable.findInScope(param);
                    structureTable.addVariable(formalName, new Structure(found.getStructureName(), formalName, found.getValues()));
                }
            }

            Object result = procedureNode.accept(this, env);
            env.getValueTable().exitScope();
            env.getStructureTable().exitScope();
            if (dispatchNode.getWriter() != null)
                env.getValueTable().addVariable(dispatchNode.getWriter(), result);
            return result;
        }
    }

    @Override
    public Object visit(DivNode divNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(divNode.getLeft(), env);
        int right = parseIntegerOperand(divNode.getRight(), env);

        return Integer.toString(left / right);
    }

    @Override
    public Object visit(EqNode eqNode, ExecutionEnvironment env) {

        // Depending on the flag, EqNode can imply a comparison or an assignment
        if (env.getFlags().contains(Flag.ASSIGN)) {
            String left = (String) visit(eqNode.getLeft(), env);
            String right = (String) visit(eqNode.getRight(), env);
            env.getValueTable().addVariable(left, right);
            return left;
        } else {
            String left = (String) visit(eqNode.getLeft(), env);
            String right = (String) visit(eqNode.getRight(), env);

            if(left == null || right == null)
                return Boolean.toString(false);

            return Boolean.toString(left.equals(right));
        }
    }


    @Override
    public Object visit(GEqNode gEqNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(gEqNode.getLeft(), env);
        int right = parseIntegerOperand(gEqNode.getRight(), env);

        return Boolean.toString(left >= right);
    }

    @Override
    public Object visit(GTNode gtNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(gtNode.getLeft(), env);
        int right = parseIntegerOperand(gtNode.getRight(), env);

        return Boolean.toString(left > right);
    }

    @Override
    public Object visit(HeadingNode headingNode, ExecutionEnvironment env) {
        visit(headingNode.getReaders(), env);
        visit(headingNode.getWriters(), env);
        return null;
    }

    @Override
    public Object visit(LEqNode lEqNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(lEqNode.getLeft(), env);
        int right = parseIntegerOperand(lEqNode.getRight(), env);

        return Boolean.toString(left <= right);
    }

    @Override
    public Object visit(LTNode ltNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(ltNode.getLeft(), env);
        int right = parseIntegerOperand(ltNode.getRight(), env);

        return Boolean.toString(left < right);
    }

    @Override
    public Object visit(MulNode mulNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(mulNode.getLeft(), env);
        int right = parseIntegerOperand(mulNode.getRight(), env);

        return Integer.toString(left * right);
    }

    @Override
    public Object visit(PlusNode plusNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(plusNode.getLeft(), env);
        int right = parseIntegerOperand(plusNode.getRight(), env);

        return Integer.toString(left + right);
    }


    @Override
    public Object visit(ReaderContainerNode readerContainerNode, ExecutionEnvironment env) {
        String lastReaderName = null;
        for (ReaderNode readerNode : readerContainerNode.getReaderNodes())
            lastReaderName = (String) visit(readerNode, env);
        return lastReaderName;
    }

    @Override
    public Object visit(WriterContainerNode writerContainerNode, ExecutionEnvironment env) {
        String lastWriterNode = null;
        for (WriterNode readerNode : writerContainerNode.getWriterNodes())
            lastWriterNode = (String) visit(readerNode, env);
        return lastWriterNode;
    }


    @Override
    public Object visit(StructureNode structureNode, ExecutionEnvironment env) {
        List<String> actualValues = new ArrayList<>();
        for (ExpressionNode expr : structureNode.getValues())
            actualValues.add((String) visit(expr, env));

        if (env.getFlags().contains(Flag.ASSIGN)) {
            // TODO decide if comparing string representations of structure name + values is ideal or not
            String representation = structureNode.getVarName() + STRUCTURE_IDENTIFIER;

            env.getValueTable().addVariable(structureNode.getVarName(), representation);
            env.getStructureTable().addVariable(structureNode.getVarName(), new Structure(structureNode.getStructureName(), structureNode.getVarName(), actualValues));
            return structureNode.getVarName();
        } else {
            // Alias variables when you visit a structure node in a comparison sense
            Structure existingStructure = env.getStructureTable().findInScope(structureNode.getVarName());

            if(existingStructure == null || existingStructure.getValues().size() != structureNode.getValues().size())
                return Boolean.toString(false);

            List<String> retrievedActuals = existingStructure.getValues();

            for (int i = 0; i<structureNode.getValues().size(); i++) {
                ExpressionNode expr = structureNode.getValues().get(i);

                String variableName = (String) visit(expr, env);

                if(retrievedActuals.get(i).contains(STRUCTURE_IDENTIFIER)) {
                    String originalVariableName = retrievedActuals.get(i).replace(STRUCTURE_IDENTIFIER, "");
                    Structure aliasedStructure = env.getStructureTable().findInScope(originalVariableName);

                    Structure newStructure = new Structure(aliasedStructure.getStructureName(), variableName, aliasedStructure.getValues());
                    env.getStructureTable().addVariable(variableName, newStructure);
                }

                env.getValueTable().addVariable(variableName, retrievedActuals.get(i));
            }

            return Boolean.toString(existingStructure.getStructureName().equals(structureNode.getStructureName())
                    && actualValues.size() == retrievedActuals.size());
        }
    }

    @Override
    public Object visit(ReaderNode readerNode, ExecutionEnvironment env) {
        return readerNode.getName();
    }

    @Override
    public Object visit(ExpressionNode expressionNode, ExecutionEnvironment env) {
        // Done differently to allow dynamic dispatch TODO investigate
        return expressionNode.accept(this, env);
    }

    @Override
    public Object visit(SubNode subNode, ExecutionEnvironment env) {
        int left = parseIntegerOperand(subNode.getLeft(), env);
        int right = parseIntegerOperand(subNode.getRight(), env);

        return Integer.toString(left - right);
    }

    @Override
    public Object visit(TellNode tellNode, ExecutionEnvironment env) {
        return visit(tellNode.getExpressionNode(), env);
    }

    @Override
    public Object visit(WriterNode writerNode, ExecutionEnvironment env) {
        return writerNode.getName();
    }

    @Override
    public Object visit(BooleanNode booleanNode, ExecutionEnvironment env) {
        return booleanNode.getNodeValue();
    }

    @Override
    public Object visit(IdentifierNode identifierNode, ExecutionEnvironment env) {
        String identifierNodeValue = identifierNode.getNodeValue();
        if (env.getValueTable().findInScope(identifierNodeValue) == null || env.getFlags().contains(Flag.ID_ONLY))
            return identifierNodeValue;
        return env.getValueTable().findInScope(identifierNodeValue);
    }


    @Override
    public Object visit(IntegerNode integerNode, ExecutionEnvironment env) {
        return Integer.toString(integerNode.getNodeValue());
    }

    @Override
    public Object visit(StringConstNode stringConstNode, ExecutionEnvironment env) {
        return stringConstNode.getNodeValue();
    }

    private <T extends ExpressionNode> int parseIntegerOperand(T operand, ExecutionEnvironment env) {
        String parsedOperand = (String) visit(operand, env);
        try {
            return Integer.parseInt(parsedOperand);
        } catch (NumberFormatException e) {
            return Integer.parseInt((String) env.getValueTable().findInScope(parsedOperand));
        }
    }
}
