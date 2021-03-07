package visitor.customised;

import nodes.*;
import nodes.data.*;

public interface CustomVisitor<T, D> {

    T visit(ClassNode classNode, D data);

    T visit(RegularRuleNode ruleNode, D data);

    T visit(FinalRuleNode finalRuleNode, D data);

    T visit(AskNode askNode, D data);

    T visit(BodyNode bodyNode, D data);

    T visit(DispatchNode dispatchNode, D data);

    T visit(DivNode divNode, D data);

    T visit(EqNode eqNode, D data);

    T visit(GEqNode gEqNode, D data);

    T visit(GTNode gtNode, D data);

    T visit(HeadingNode headingNode, D data);

    T visit(LEqNode lEqNode, D data);

    T visit(LTNode ltNode, D data);

    T visit(MulNode mulNode, D data);

    T visit(PlusNode plusNode, D data);

    T visit(ProcedureNode procedureNode, D data);

    T visit(ReaderContainerNode readerContainerNode, D data);

    T visit(WriterContainerNode writerContainerNode, D data);

    T visit(ReaderNode readerNode, D data);

    T visit(ExpressionNode expressionNode, D data);

    T visit(SubNode subNode, D data);

    T visit(TellNode tellNode, D data);

    T visit(WriterNode writerNode, D data);

    T visit(BooleanNode booleanNode, D data);

    T visit(IdentifierNode identifierNode, D data);

    T visit(IntegerNode integerNode, D data);

    T visit(StringConstNode stringConstNode, D data);

    T visit(SequentialProcedureNode sequentialProcedureNode, D data);

    T visit(SequentialBodyNode sequentialBodyNode, D data);
}
