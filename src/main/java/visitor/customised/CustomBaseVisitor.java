package visitor.customised;

import nodes.*;
import nodes.data.BooleanNode;
import nodes.data.IdentifierNode;
import nodes.data.IntegerNode;
import nodes.data.StringConstNode;

public class CustomBaseVisitor<T, D> implements CustomVisitor<T, D> {

    protected final T returnValue;

    protected CustomBaseVisitor() {
        returnValue = null;
    }

    protected final T base(TreeNode node, D data) {
        return returnValue;
    }

    protected final T visit(Iterable<? extends TreeNode> nodes, D data) {
        T t = null;
        if(nodes != null)
            for(TreeNode node : nodes)
                t = visit(node, data);
        return t;
    }

    @Override
    public final T visit(TreeNode treeNode, D data) {
        return visit(treeNode.getChildren(), data);
    }

    @Override
    public T visit(ClassNode classNode, D data) {
        return visit(classNode.getChildren(), data);
    }

    @Override
    public T visit(RegularRuleNode ruleNode, D data) {
        return visit(ruleNode.getChildren(), data);
    }

    @Override
    public T visit(FinalRuleNode finalRuleNode, D data) {
        return visit(finalRuleNode.getChildren(), data);
    }

    @Override
    public T visit(AskNode askNode, D data) {
        return visit(askNode.getChildren(), data);
    }

    @Override
    public T visit(BodyNode bodyNode, D data) {
        return visit(bodyNode.getChildren(), data);
    }

    @Override
    public T visit(DispatchNode dispatchNode, D data) {
        return visit(dispatchNode.getChildren(), data);
    }

    @Override
    public T visit(DivNode divNode, D data) {
        return visit(divNode.getChildren(), data);
    }

    @Override
    public T visit(EqNode eqNode, D data) {
        return visit(eqNode.getChildren(), data);
    }

    @Override
    public T visit(GEqNode gEqNode, D data) {
        return visit(gEqNode.getChildren(), data);
    }

    @Override
    public T visit(GTNode gtNode, D data) {
        return visit(gtNode.getChildren(), data);
    }

    @Override
    public T visit(HeadingNode headingNode, D data) {
        return visit(headingNode.getChildren(), data);
    }

    @Override
    public T visit(LEqNode lEqNode, D data) {
        return visit(lEqNode.getChildren(), data);
    }

    @Override
    public T visit(LTNode ltNode, D data) {
        return visit(ltNode.getChildren(), data);
    }

    @Override
    public T visit(MulNode mulNode, D data) {
        return visit(mulNode.getChildren(), data);
    }

    @Override
    public T visit(PlusNode plusNode, D data) {
        return visit(plusNode.getChildren(), data);
    }

    @Override
    public T visit(ProcedureNode procedureNode, D data) {
        return visit(procedureNode.getChildren(), data);
    }

    @Override
    public T visit(ReaderNode readerNode, D data) {
        return visit(readerNode.getChildren(), data);
    }

    @Override
    public T visit(SubNode subNode, D data) {
        return visit(subNode.getChildren(), data);
    }

    @Override
    public T visit(TellNode tellNode, D data) {
        return visit(tellNode.getChildren(), data);
    }

    @Override
    public T visit(WriterNode writerNode, D data) {
        return visit(writerNode.getChildren(), data);
    }

    @Override
    public T visit(BooleanNode booleanNode, D data) {
        return visit(booleanNode.getChildren(), data);
    }

    @Override
    public T visit(IdentifierNode identifierNode, D data) {
        return visit(identifierNode.getChildren(), data);
    }

    @Override
    public T visit(IntegerNode integerNode, D data) {
        return visit(integerNode.getChildren(), data);
    }

    @Override
    public T visit(StringConstNode stringConstNode, D data) {
        return visit(stringConstNode.getChildren(), data);
    }
}
