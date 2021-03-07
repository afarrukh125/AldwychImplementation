package visitor.customised;

import helpers.ValueTable;
import nodes.*;
import nodes.data.*;

import java.util.List;

public class ExecutionVisitor implements CustomVisitor<Object, Object> {

    private final ValueTable valueTable;

    public ExecutionVisitor() {
        valueTable = new ValueTable();
    }

    @Override
    public Object visit(ClassNode classNode, Object data) {
        for(ProcedureNode procedureNode : classNode.getProcedures())
            visit(procedureNode, data);
        return null;
    }

    @Override
    public Object visit(RegularRuleNode ruleNode, Object data) {
        List<AskNode> asks = ruleNode.getAsks();
        List<TellNode> tells = ruleNode.getTells();

        for(AskNode askNode : asks)
            visit(askNode, data);

        for(TellNode tellNode : tells)
            visit(tellNode, data);
        return null;
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, Object data) {
        return null;
    }

    @Override
    public Object visit(AskNode askNode, Object data) {
        return visit(askNode.getExpressionNode(), data);
    }

    @Override
    public Object visit(BodyNode bodyNode, Object data) {
        for(RegularRuleNode regularRuleNode : bodyNode.getRegularRules())
            visit(regularRuleNode, data);

        visit(bodyNode.getFinalRule(), data);
        return null;
    }

    @Override
    public Object visit(DispatchNode dispatchNode, Object data) {
        return null;
    }

    @Override
    public Object visit(DivNode divNode, Object data) {
        return null;
    }

    @Override
    public Object visit(EqNode eqNode, Object data) {
        return null;
    }

    @Override
    public Object visit(GEqNode gEqNode, Object data) {
        return null;
    }

    @Override
    public Object visit(GTNode gtNode, Object data) {
        return null;
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
        return null;
    }

    @Override
    public Object visit(ProcedureNode procedureNode, Object data) {
        visit(procedureNode.getHeadingNode(), data);
        visit(procedureNode.getBody(), data);
        return null;
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
     * @param expressionNode
     * @param data
     * @return
     */
    @Override
    public Object visit(ExpressionNode expressionNode, Object data) {
        if(expressionNode instanceof GTNode)
            return visit((GTNode) expressionNode, data);
        if(expressionNode instanceof LTNode)
            return visit((LTNode) expressionNode, data);
        if(expressionNode instanceof EqNode)
            return visit((EqNode) expressionNode, data);


        throw new IllegalArgumentException("No expression node to visit for this: " + expressionNode.getClass().getSimpleName());
    }

    @Override
    public Object visit(SubNode subNode, Object data) {
        IntegerNode left = (IntegerNode) visit((ExpressionNode) subNode.getLeft(), data);
        IntegerNode right = (IntegerNode) visit((ExpressionNode) subNode.getRight(), data);

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
        return null;
    }

    @Override
    public Object visit(IntegerNode integerNode, Object data) {
        return integerNode.getNodeValue();
    }

    @Override
    public Object visit(StringConstNode stringConstNode, Object data) {
        return stringConstNode.getNodeValue();
    }
}
