package visitor.customised;

import nodes.*;
import nodes.data.BooleanNode;
import nodes.data.IdentifierNode;
import nodes.data.IntegerNode;
import nodes.data.StringConstNode;

public interface CustomVisitor<T, D> {

    public T visit(TreeNode treeNode, D data);

    public T visit(ClassNode classNode, D data);

    public T visit(RegularRuleNode ruleNode, D data);

    public T visit(FinalRuleNode finalRuleNode, D data);

    public T visit(AskNode askNode, D data);

    public T visit(BodyNode bodyNode, D data);

    public T visit(DispatchNode dispatchNode, D data);

    public T visit(DivNode divNode, D data);

    public T visit(EqNode eqNode, D data);

    public T visit(GEqNode gEqNode, D data);

    public T visit(GTNode gtNode, D data);

    public T visit(HeadingNode headingNode, D data);

    public T visit(LEqNode lEqNode, D data);

    public T visit(LTNode ltNode, D data);

    public T visit(MulNode mulNode, D data);

    public T visit(PlusNode plusNode, D data);

    public T visit(ProcedureNode procedureNode, D data);

    public T visit(ReaderContainerNode readerContainerNode, D data);

    public T visit(SubNode subNode, D data);

    public T visit(TellNode tellNode, D data);

    public T visit(WriterNode writerNode, D data);

    public T visit(BooleanNode booleanNode, D data);

    public T visit(IdentifierNode identifierNode, D data);

    public T visit(IntegerNode integerNode, D data);

    public T visit(StringConstNode stringConstNode, D data);
}
