package visitor.customised;

import nodes.*;
import nodes.data.BooleanNode;
import nodes.data.IdentifierNode;
import nodes.data.IntegerNode;
import nodes.data.StringConstNode;

public interface CustomVisitor<T> {

    public T visitClassNode(ClassNode classNode);

    public T visitRegularRuleNode(RegularRuleNode ruleNode);

    public T visitFinalRuleNode(FinalRuleNode finalRuleNode);

    public T visitAskNode(AskNode askNode);

    public T visitBodyNode(BodyNode bodyNode);

    public T visitDispatchNode(DispatchNode dispatchNode);

    public T visitDivNode(DivNode divNode);

    public T visitEqNode(EqNode eqNode);

    public T visitGEqNode(GEqNode gEqNode);

    public T visitGTNode(GTNode gtNode);

    public T visit(HeadingNode headingNode);

    public T visitLEqNode(LEqNode lEqNode);

    public T visitLTNode(LTNode ltNode);

    public T visitMulNode(MulNode mulNode);

    public T visitPlusNode(PlusNode plusNode);

    public T visitProcedureNode(ProcedureNode procedureNode);

    public T visitReaderNode(ReaderNode readerNode);

    public T visitSubNode(SubNode subNode);

    public T visitTellNode(TellNode tellNode);

    public T visitWriterNode(WriterNode writerNode);

    public T visitBooleanNode(BooleanNode booleanNode);

    public T visitIdentifierNode(IdentifierNode identifierNode);

    public T visitIntegerNode(IntegerNode integerNode);

    public T visitStringConstNode(StringConstNode stringConstNode);
}
