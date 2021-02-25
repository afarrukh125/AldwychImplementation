package visitor;

import nodes.*;
import nodes.data.BooleanNode;
import nodes.data.IdentifierNode;
import nodes.data.IntegerNode;
import nodes.data.StringConstNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Used to build our tree to then execute afterwards
 * This is done as a frontend step
 */
public class AldTreeBuilder extends AldParserBaseVisitor<TreeNode> {

    @Override
    public TreeNode visitAldwychClass(AldParser.AldwychClassContext ctx) {
        ClassNode classNode = new ClassNode();

        for (AldParser.DeclarationContext decl : ctx.declaration()) {
            classNode.addChild(visit(decl));
        }

        return classNode;
    }

    @Override
    public TreeNode visitProcedureNode(AldParser.ProcedureNodeContext ctx) {
        ProcedureNode procedureNode = new ProcedureNode();
        procedureNode.addChild(visit(ctx.heading()));
        procedureNode.addChild(visit(ctx.body()));
        return procedureNode;
    }

    // TODO remove this when we get a nice variable ecosystem (no global variables)
    @Override
    public TreeNode visitDeclarationNode(AldParser.DeclarationNodeContext ctx) {
        return super.visitDeclarationNode(ctx);
    }

    @Override
    public TreeNode visitHeading(AldParser.HeadingContext ctx) {
        HeadingNode node = new HeadingNode(ctx.name().ID().getText());
        return node;
    }

    @Override
    public TreeNode visitName(AldParser.NameContext ctx) {
        return super.visitName(ctx);
    }

    @Override
    public TreeNode visitVariables(AldParser.VariablesContext ctx) {
        return super.visitVariables(ctx);
    }

    @Override
    public TreeNode visitReader(AldParser.ReaderContext ctx) {
        ReaderNode readers = new ReaderNode();

        for (TerminalNode reader : ctx.ID())
            readers.addChild(visit(reader));

        return readers;
    }

    @Override
    public TreeNode visitWriter(AldParser.WriterContext ctx) {
        WriterNode writers = new WriterNode();

        for (TerminalNode writer : ctx.ID())
            writers.addChild(visit(writer));

        return writers;
    }

    @Override
    public TreeNode visitBody(AldParser.BodyContext ctx) {
        BodyNode bodyNode = new BodyNode();
        for (AldParser.RegularruleContext regularruleContext : ctx.regularrule())
            bodyNode.addChild(visit(regularruleContext));
        bodyNode.addChild(visit(ctx.finalrule()));
        return bodyNode;
    }

    @Override
    public TreeNode visitRegularrule(AldParser.RegularruleContext ctx) {
        RegularRuleNode regularRuleNode = new RegularRuleNode();
        regularRuleNode.addChild(visit(ctx.ask()));
        regularRuleNode.addChild(visit(ctx.tell()));

        return regularRuleNode;
    }

    @Override
    public TreeNode visitAskNode(AldParser.AskNodeContext ctx) {
        AskNode askNode = new AskNode();

        for (AldParser.ExprContext exp : ctx.expr())
            askNode.addChild(visit(exp));

        return askNode;
    }

    @Override
    public TreeNode visitTellNode(AldParser.TellNodeContext ctx) {
        TellNode tellNode = new TellNode();

        for (AldParser.ExprContext exp : ctx.expr())
            tellNode.addChild(visit(exp));

        return tellNode;
    }

    @Override
    public TreeNode visitFinalrule(AldParser.FinalruleContext ctx) {
        FinalRuleNode node = new FinalRuleNode();
        node.addChild(visit(ctx.tell()));
        return node;
    }

    @Override
    public TreeNode visitLtNode(AldParser.LtNodeContext ctx) {
        TreeNode left = visit(ctx.expr(0));
        TreeNode right = visit(ctx.expr(1));

        return new LTNode(left, right);
    }

    @Override
    public TreeNode visitStringConstNode(AldParser.StringConstNodeContext ctx) {
        return new StringConstNode(ctx.getText());
    }

    @Override
    public TreeNode visitGEqNode(AldParser.GEqNodeContext ctx) {
        TreeNode left = visit(ctx.expr(0));
        TreeNode right = visit(ctx.expr(1));

        return new GEqNode(left, right);
    }

    @Override
    public TreeNode visitGTNode(AldParser.GTNodeContext ctx) {
        TreeNode left = visit(ctx.expr(0));
        TreeNode right = visit(ctx.expr(1));

        return new GTNode(left, right);
    }

    @Override
    public TreeNode visitDivMultNode(AldParser.DivMultNodeContext ctx) {
        TreeNode left = visit(ctx.expr(0));
        TreeNode right = visit(ctx.expr(1));

        if (ctx.DIV_OPERATOR() != null)
            return new DivNode(left, right);
        return new MulNode(left, right);
    }

    @Override
    public TreeNode visitMinusPlusNode(AldParser.MinusPlusNodeContext ctx) {
        TreeNode left = visit(ctx.expr(0));
        TreeNode right = visit(ctx.expr(1));

        if (ctx.MINUS_OPERATOR() != null)
            return new SubNode(left, right);
        return new PlusNode(left, right);
    }

    @Override
    public TreeNode visitIntegerNode(AldParser.IntegerNodeContext ctx) {
        return new IntegerNode(ctx.getText());
    }

    @Override
    public TreeNode visitEqNode(AldParser.EqNodeContext ctx) {
        TreeNode left = visit(ctx.expr(0));
        TreeNode right = visit(ctx.expr(1));
        return new EqNode(left, right);
    }

    @Override
    public TreeNode visitIdentifierNode(AldParser.IdentifierNodeContext ctx) {
        return new IdentifierNode(ctx.ID().getText());
    }

    @Override
    public TreeNode visitTrue(AldParser.TrueContext ctx) {
        return new BooleanNode(true);
    }

    @Override
    public TreeNode visitFalse(AldParser.FalseContext ctx) {
        return new BooleanNode(false);
    }

    @Override
    public TreeNode visitLEqNode(AldParser.LEqNodeContext ctx) {
        TreeNode left = visit(ctx.expr(0));
        TreeNode right = visit(ctx.expr(1));

        return new LEqNode(left, right);
    }

    @Override
    public TreeNode visitDispatchNode(AldParser.DispatchNodeContext ctx) {
        return super.visitDispatchNode(ctx);
    }
}
