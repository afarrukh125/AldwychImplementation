package visitor;

import nodes.*;
import nodes.data.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to build our tree to then execute afterwards
 * This is done as a frontend step
 */
public class AldTreeBuilder extends AldParserBaseVisitor<TreeNode> {

    @Override
    public TreeNode visitAldwychClass(AldParser.AldwychClassContext ctx) {
        ClassNode classNode = new ClassNode();

        for (AldParser.DeclarationContext decl : ctx.declaration()) {
            TreeNode result = visit(decl);
            if(decl instanceof AldParser.ProcedureNodeContext)
                classNode.addProcedureNode((ProcedureNode) result);

            if(decl instanceof AldParser.SequentialProcedureNodeContext)
                classNode.addSequentialProcedureNode((SequentialProcedureNode) result);

        }

        return classNode;
    }

    @Override
    public TreeNode visitProcedureNode(AldParser.ProcedureNodeContext ctx) {
        HeadingNode headingNode = (HeadingNode) visit(ctx.heading());
        BodyNode bodyNode = (BodyNode) visit(ctx.body());
        return new ProcedureNode(headingNode, bodyNode);
    }

    // TODO remove this when we get a nice variable ecosystem (no global variables)
    @Override
    public TreeNode visitDeclarationNode(AldParser.DeclarationNodeContext ctx) {
        return super.visitDeclarationNode(ctx);
    }

    @Override
    public TreeNode visitHeading(AldParser.HeadingContext ctx) {
        ReaderContainerNode readers = (ReaderContainerNode) visit(ctx.formals().readers());
        WriterContainerNode writers = (WriterContainerNode) visit(ctx.formals().writers());

        HeadingNode node = new HeadingNode(ctx.name().ID().getText(), readers, writers);
        return node;
    }

    @Override
    public TreeNode visitName(AldParser.NameContext ctx) {
        return super.visitName(ctx);
    }

    @Override
    public TreeNode visitFormals(AldParser.FormalsContext ctx) {
        return super.visitFormals(ctx);
    }

    @Override
    public TreeNode visitReaders(AldParser.ReadersContext ctx) {
        ReaderContainerNode readers = new ReaderContainerNode();

        for(TerminalNode tn : ctx.ID())
            readers.addReaderNode(new ReaderNode(tn.getText()));

        return readers;
    }

    @Override
    public TreeNode visitWriters(AldParser.WritersContext ctx) {
        WriterContainerNode writers = new WriterContainerNode();

        for (TerminalNode writer : ctx.ID())
            writers.addWriter(new WriterNode(writer.getText()));

        return writers;
    }

    @Override
    public TreeNode visitSequentialProcedureNode(AldParser.SequentialProcedureNodeContext ctx) {
        HeadingNode headingNode = (HeadingNode) visit(ctx.heading());
        SequentialBodyNode bodyNode = (SequentialBodyNode) visit(ctx.seqbody());
        return new SequentialProcedureNode(headingNode, bodyNode);
    }

    @Override
    public TreeNode visitSeqbody(AldParser.SeqbodyContext ctx) {
        SequentialBodyNode sequentialBodyNode = new SequentialBodyNode();
        for(AldParser.ExprContext exprContext : ctx.expr())
            sequentialBodyNode.addExpression((ExpressionNode) visit(exprContext));
        return sequentialBodyNode;
    }

    @Override
    public TreeNode visitBody(AldParser.BodyContext ctx) {
        BodyNode bodyNode = new BodyNode();

        for (AldParser.RegularruleContext regularruleContext : ctx.regularrule())
            bodyNode.addRegularRule((RegularRuleNode) visit(regularruleContext));

        bodyNode.setFinalRule((FinalRuleNode) visit(ctx.finalrule()));

        return bodyNode;
    }

    @Override
    public TreeNode visitRegularrule(AldParser.RegularruleContext ctx) {
        RegularRuleNode regularRuleNode = new RegularRuleNode();

        for(AldParser.AskContext askContext : ctx.ask()) {
            AskNode askNode = (AskNode) visit(askContext);
            regularRuleNode.addAsk(askNode);
        }

        for(AldParser.TellContext tellContext : ctx.tell()) {
            TellNode tellNode = (TellNode) visit(tellContext);
            regularRuleNode.addTell(tellNode);
        }

        return regularRuleNode;
    }

    @Override
    public TreeNode visitAskNode(AldParser.AskNodeContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode) visit(ctx.expr());
        return new AskNode(expressionNode);
    }

    @Override
    public TreeNode visitTellNode(AldParser.TellNodeContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode) visit(ctx.expr());
        return new TellNode(expressionNode);
    }

    @Override
    public TreeNode visitFinalrule(AldParser.FinalruleContext ctx) {
        FinalRuleNode node = new FinalRuleNode();

        for(AldParser.TellContext tellContext : ctx.tell()) {
            TellNode tellNode = (TellNode) visit(tellContext);
            node.addTell(tellNode);
        }
        return node;
    }

    @Override
    public TreeNode visitLtNode(AldParser.LtNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new LTNode(left, right);
    }

    @Override
    public TreeNode visitStringConstNode(AldParser.StringConstNodeContext ctx) {
        return new StringConstNode(ctx.getText());
    }

    @Override
    public TreeNode visitGEqNode(AldParser.GEqNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new GEqNode(left, right);
    }

    @Override
    public TreeNode visitGTNode(AldParser.GTNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new GTNode(left, right);
    }

    @Override
    public TreeNode visitDivMultNode(AldParser.DivMultNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        if (ctx.DIV_OPERATOR() != null)
            return new DivNode(left, right);
        return new MulNode(left, right);
    }

    @Override
    public TreeNode visitMinusPlusNode(AldParser.MinusPlusNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

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
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));
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
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new LEqNode(left, right);
    }

    @Override
    public TreeNode visitDispatchNode(AldParser.DispatchNodeContext ctx) {
        List<ExpressionNode> exprs = new ArrayList<>();
        for(AldParser.ExprContext exprContext : ctx.expr())
            exprs.add((ExpressionNode) visit(exprContext));

        if(ctx.expr().size() == 1)
            return new DispatchNode(ctx.ID(0).getText(), exprs, null);
        return new DispatchNode(ctx.ID(0).getText(), exprs, ctx.ID(1).getText());
    }
}
