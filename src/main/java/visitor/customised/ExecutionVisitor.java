package visitor.customised;

import com.sun.org.apache.xpath.internal.operations.Bool;
import helpers.MethodTable;
import helpers.ValueTable;
import nodes.*;
import nodes.data.*;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExecutionVisitor implements CustomVisitor<Object, Object> {

    private final ValueTable valueTable;
    private final MethodTable methodTable;

    public ExecutionVisitor() {
        valueTable = new ValueTable();
        methodTable = new MethodTable();
    }

    @Override
    public Object visit(ClassNode classNode, Object data) {
        data = new Object();

        for (SequentialProcedureNode procedureNode : classNode.getSequentialProcedureNodes())
            methodTable.addMethod(procedureNode.getHeadingNode().getName(), procedureNode);

        for (ProcedureNode procedureNode : classNode.getProcedures())
            methodTable.addMethod(procedureNode.getHeadingNode().getName(), procedureNode);

        for (SequentialProcedureNode seqNode : classNode.getSequentialProcedureNodes())
            visit(seqNode, data);
        return null;
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

        String result = null;
        for (TellNode tellNode : tells)
            result = (String) visit(tellNode, data);
        return result;
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, Object data) {
        for (TellNode tellNode : finalRuleNode.getTells())
            visit(tellNode.getExpressionNode(), data);
        return finalRuleNode;
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
        String lastWriterVariable = writers.get(writers.size()-1).getName();

        int numRules = bodyNode.getRegularRules().size();

        ExecutorService executorService = Executors.newFixedThreadPool(numRules);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        for (RegularRuleNode regularRuleNode : bodyNode.getRegularRules())
            completionService.submit(() -> (String) visit(regularRuleNode, data));

        int receivedCount = 0;
        String resultingValue = null;

        while(!executorService.isTerminated() && receivedCount < numRules) {
            try {
                Future<String> resultFuture = completionService.take();
                String resultNode = resultFuture.get();
                if(resultNode != null) {
                    resultingValue = (String) valueTable.findInScope(lastWriterVariable);
                    executorService.shutdownNow();
                }
                receivedCount++;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        if(resultingValue == null) {
            if(!executorService.isTerminated())
                executorService.shutdownNow();
            visit(bodyNode.getFinalRule(), data);
            return (String) valueTable.findInScope(lastWriterVariable);
        }
        return resultingValue;
    }


    @Override
    public Object visit(SequentialProcedureNode sequentialProcedureNode, Object data) {
        valueTable.enterScope();
        visit(sequentialProcedureNode.getHeadingNode(), data);
        visit(sequentialProcedureNode.getSequentialBody(), data);
        valueTable.exitScope();
        return null;
    }

    @Override
    public Object visit(SequentialBodyNode sequentialBodyNode, Object data) {
        for (ExpressionNode expressionNode : sequentialBodyNode.getExpressions())
            visit(expressionNode, data);
        return null;
    }


    @Override
    public Object visit(AssignNode assignNode, Object data) {
        String left = (String) visit(assignNode.getLeft(), data);
        String right = (String) visit(assignNode.getRight(), data);

        valueTable.addVariable(left, right);
        return null;
    }

    @Override
    public Object visit(DispatchNode dispatchNode, Object data) {

        String procedureName = dispatchNode.getName();

        if (methodTable.canHandle(procedureName)) {
            List<String> dispatchParams = new ArrayList<>();

            for(ExpressionNode expressionNode : dispatchNode.getParams()) {
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

            List<String> dispatchParams = dispatchNode.getParams()
                    .stream()
                    .map(e -> (String) visit(e, data))
                    .collect(Collectors.toList());

            valueTable.enterScope();
            for (int i = 0; i < dispatchNode.getParams().size(); i++) {
                // The name of the variable as it is known in the context of the procedure
                // e.g. a b c in #p(a, b, c)
                String formalName = formalParameters.get(i);
                // e.g. x y z in meth(x, y, z) - the actual dispatch call
                String param = dispatchParams.get(i);
                valueTable.addVariable(param, valueTable.findInScope(formalName));
            }

            Object result = procedureNode.accept(this, data);
            valueTable.exitScope();
            if (dispatchNode.getWriter() != null)
                valueTable.addVariable(dispatchNode.getWriter(), result);
            return result;
        }
    }

    @Override
    public Object visit(DivNode divNode, Object data) {
        return null;
    }

    @Override
    public Object visit(EqNode eqNode, Object data) {
        String left = (String) visit(eqNode.getLeft(), data);
        String right = (String) visit(eqNode.getRight(), data);

        return left.equals(right);
    }


    @Override
    public Object visit(GEqNode gEqNode, Object data) {
        return null;
    }

    @Override
    public Object visit(GTNode gtNode, Object data) {
        String leftString = (String) visit(gtNode.getLeft(), data);
        String rightString = (String) visit(gtNode.getRight(), data);
        int left = Integer.parseInt(leftString);
        int right = Integer.parseInt(rightString);

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
        return null;
    }

    @Override
    public Object visit(LTNode ltNode, Object data) {
        return null;
    }

    @Override
    public Object visit(MulNode mulNode, Object data) {
        return null;
    }

    @Override
    public Object visit(PlusNode plusNode, Object data) {
        String leftString = (String) visit(plusNode.getLeft(), data);
        String rightString = (String) visit(plusNode.getRight(), data);
        int left = Integer.parseInt(leftString);
        int right = Integer.parseInt(rightString);

        return Integer.toString(left + right);
    }


    @Override
    public Object visit(ReaderContainerNode readerContainerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(WriterContainerNode writerContainerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(ReaderNode readerNode, Object data) {
        return null;
    }

    /**
     * Portal for other expression nodes to be casted to here
     * TODO complete method description, redo this JavaDoc comment
     */
    @Override
    public Object visit(ExpressionNode expressionNode, Object data) {
        return expressionNode.accept(this, data);
    }

    @Override
    public Object visit(SubNode subNode, Object data) {
        IntegerNode left = (IntegerNode) visit(subNode.getLeft(), data);
        IntegerNode right = (IntegerNode) visit(subNode.getRight(), data);

        return left.getNodeValue() + right.getNodeValue();
    }

    @Override
    public Object visit(TellNode tellNode, Object data) {
        return visit(tellNode.getExpressionNode(), data);
    }

    @Override
    public Object visit(WriterNode writerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(BooleanNode booleanNode, Object data) {
        return booleanNode.getNodeValue();
    }

    @Override
    public Object visit(IdentifierNode identifierNode, Object data) {
        String identifierNodeValue = identifierNode.getNodeValue();
        if (valueTable.findInScope(identifierNodeValue) == null)
            return identifierNodeValue;
        return valueTable.findInScope(identifierNode.getNodeValue());
    }


    @Override
    public Object visit(IntegerNode integerNode, Object data) {
        return Integer.toString(integerNode.getNodeValue());
    }

    @Override
    public Object visit(StringConstNode stringConstNode, Object data) {
        return stringConstNode.getNodeValue();
    }
}
