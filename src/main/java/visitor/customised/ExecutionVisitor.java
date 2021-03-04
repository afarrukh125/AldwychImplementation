package visitor.customised;

import helpers.ValueTable;
import nodes.*;
import nodes.data.*;

import java.util.List;

public class ExecutionVisitor implements CustomVisitor<Void, Object> {

    private final ValueTable valueTable;

    public ExecutionVisitor() {
        valueTable = new ValueTable();
    }

    @Override
    public Void visit(ClassNode classNode, Object data) {
        for(ProcedureNode procedureNode : classNode.getProcedures())
            visit(procedureNode, data);
        return null;
    }

    @Override
    public Void visit(RegularRuleNode ruleNode, Object data) {
        List<AskNode> asks = ruleNode.getAsks();
        List<TellNode> tells = ruleNode.getTells();
        return null;
    }

    @Override
    public Void visit(FinalRuleNode finalRuleNode, Object data) {
        return null;
    }

    @Override
    public Void visit(AskNode askNode, Object data) {
        return null;
    }

    @Override
    public Void visit(BodyNode bodyNode, Object data) {
        for(RegularRuleNode regularRuleNode : bodyNode.getRegularRules())
            visit(regularRuleNode, data);

        visit(bodyNode.getFinalRule(), data);
        return null;
    }

    @Override
    public Void visit(DispatchNode dispatchNode, Object data) {
        return null;
    }

    @Override
    public Void visit(DivNode divNode, Object data) {
        return null;
    }

    @Override
    public Void visit(EqNode eqNode, Object data) {
        return null;
    }

    @Override
    public Void visit(GEqNode gEqNode, Object data) {
        return null;
    }

    @Override
    public Void visit(GTNode gtNode, Object data) {
        return null;
    }

    @Override
    public Void visit(HeadingNode headingNode, Object data) {
        visit(headingNode.getReaders(), data);
        visit(headingNode.getWriters(), data);
        return null;
    }

    @Override
    public Void visit(LEqNode lEqNode, Object data) {
        return null;
    }

    @Override
    public Void visit(LTNode ltNode, Object data) {
        return null;
    }

    @Override
    public Void visit(MulNode mulNode, Object data) {
        return null;
    }

    @Override
    public Void visit(PlusNode plusNode, Object data) {
        return null;
    }

    @Override
    public Void visit(ProcedureNode procedureNode, Object data) {
        visit(procedureNode.getHeadingNode(), data);
        visit(procedureNode.getBody(), data);
        return null;
    }

    @Override
    public Void visit(ReaderContainerNode readerContainerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(WriterContainerNode writerContainerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(ReaderNode readerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(ExpressionNode expressionNode, Object data) {
        return null;
    }

    @Override
    public Void visit(SubNode subNode, Object data) {
        return null;
    }

    @Override
    public Void visit(TellNode tellNode, Object data) {
        return null;
    }

    @Override
    public Void visit(WriterNode writerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(BooleanNode booleanNode, Object data) {
        return null;
    }

    @Override
    public Void visit(IdentifierNode identifierNode, Object data) {
        return null;
    }

    @Override
    public Void visit(IntegerNode integerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(StringConstNode stringConstNode, Object data) {
        return null;
    }
}