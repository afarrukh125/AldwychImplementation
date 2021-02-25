package visitor.customised;

import nodes.*;
import nodes.data.BooleanNode;
import nodes.data.IdentifierNode;
import nodes.data.IntegerNode;
import nodes.data.StringConstNode;

public class SemanticVisitor extends CustomBaseVisitor<Void, Object> {

    public SemanticVisitor() {
        super();
    }

    @Override
    public Void visit(ClassNode classNode, Object data) {
        System.out.println("Visiting classnode right now");
        visit(classNode.getChildren(), data);
        return super.visit(classNode, data);
    }

    @Override
    public Void visit(RegularRuleNode ruleNode, Object data) {
        return super.visit(ruleNode, data);
    }

    @Override
    public Void visit(FinalRuleNode finalRuleNode, Object data) {
        return super.visit(finalRuleNode, data);
    }

    @Override
    public Void visit(AskNode askNode, Object data) {
        return super.visit(askNode, data);
    }

    @Override
    public Void visit(BodyNode bodyNode, Object data) {
        return super.visit(bodyNode, data);
    }

    @Override
    public Void visit(DispatchNode dispatchNode, Object data) {
        return super.visit(dispatchNode, data);
    }

    @Override
    public Void visit(DivNode divNode, Object data) {
        return super.visit(divNode, data);
    }

    @Override
    public Void visit(EqNode eqNode, Object data) {
        return super.visit(eqNode, data);
    }

    @Override
    public Void visit(GEqNode gEqNode, Object data) {
        return super.visit(gEqNode, data);
    }

    @Override
    public Void visit(GTNode gtNode, Object data) {
        return super.visit(gtNode, data);
    }

    @Override
    public Void visit(HeadingNode headingNode, Object data) {
        return super.visit(headingNode, data);
    }

    @Override
    public Void visit(LEqNode lEqNode, Object data) {
        return super.visit(lEqNode, data);
    }

    @Override
    public Void visit(LTNode ltNode, Object data) {
        return super.visit(ltNode, data);
    }

    @Override
    public Void visit(MulNode mulNode, Object data) {
        return super.visit(mulNode, data);
    }

    @Override
    public Void visit(PlusNode plusNode, Object data) {
        return super.visit(plusNode, data);
    }

    @Override
    public Void visit(ProcedureNode procedureNode, Object data) {
        System.out.println("LOOK ITS A PROCEDURE");
        return super.visit(procedureNode, data);
    }

    @Override
    public Void visit(ReaderNode readerNode, Object data) {
        return super.visit(readerNode, data);
    }

    @Override
    public Void visit(SubNode subNode, Object data) {
        return super.visit(subNode, data);
    }

    @Override
    public Void visit(TellNode tellNode, Object data) {
        return super.visit(tellNode, data);
    }

    @Override
    public Void visit(WriterNode writerNode, Object data) {
        return super.visit(writerNode, data);
    }

    @Override
    public Void visit(BooleanNode booleanNode, Object data) {
        return super.visit(booleanNode, data);
    }

    @Override
    public Void visit(IdentifierNode identifierNode, Object data) {
        return super.visit(identifierNode, data);
    }

    @Override
    public Void visit(IntegerNode integerNode, Object data) {
        return super.visit(integerNode, data);
    }

    @Override
    public Void visit(StringConstNode stringConstNode, Object data) {
        return super.visit(stringConstNode, data);
    }
}
