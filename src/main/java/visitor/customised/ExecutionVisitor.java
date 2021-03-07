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
        return null;
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, Object data) {
        return null;
    }

    @Override
    public Object visit(AskNode askNode, Object data) {
        return null;
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

    @Override
    public Object visit(ExpressionNode expressionNode, Object data) {
        return null;
    }

    @Override
    public Object visit(SubNode subNode, Object data) {
        return null;
    }

    @Override
    public Object visit(TellNode tellNode, Object data) {
        return null;
    }

    @Override
    public Object visit(WriterNode writerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(BooleanNode booleanNode, Object data) {
        return null;
    }

    @Override
    public Object visit(IdentifierNode identifierNode, Object data) {
        return null;
    }

    @Override
    public Object visit(IntegerNode integerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(StringConstNode stringConstNode, Object data) {
        return null;
    }
}
