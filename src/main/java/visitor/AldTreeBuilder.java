package visitor;

import nodes.*;
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

        // One sequential procedure per class
        AldParser.SeqprocedureContext seqprocedureContext = ctx.seqprocedure();
        SequentialProcedureNode seqProcedureResult = (SequentialProcedureNode) visit(seqprocedureContext);

        ClassNode classNode = new ClassNode(seqProcedureResult);

        for (AldParser.DeclarationContext decl : ctx.declaration()) {
            TreeNode result = visit(decl);
            if (decl instanceof AldParser.ProcedureNodeContext)
                classNode.addProcedureNode((ProcedureNode) result);
        }

        return classNode;
    }

    @Override
    public TreeNode visitProcedureNode(AldParser.ProcedureNodeContext ctx) {
        HeadingNode headingNode = (HeadingNode) visit(ctx.heading());
        BodyNode bodyNode = (BodyNode) visit(ctx.body());
        return new ProcedureNode(headingNode, bodyNode);
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

        for (TerminalNode tn : ctx.ID())
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
        for (AldParser.ExprContext exprContext : ctx.expr())
            sequentialBodyNode.addExpression((ExpressionNode) visit(exprContext));
        return sequentialBodyNode;
    }

    @Override
    public TreeNode visitBody(AldParser.BodyContext ctx) {
        BodyNode bodyNode = new BodyNode();

        for (AldParser.RulesetContext rulesetContext : ctx.ruleset())
            bodyNode.addRuleSet((RuleSetNode) visit(rulesetContext));

        bodyNode.setFinalRule((FinalRuleNode) visit(ctx.finalrule()));
        return bodyNode;
    }

    @Override
    public TreeNode visitRuleset(AldParser.RulesetContext ctx) {

        RuleSetNode ruleSetNode = new RuleSetNode();

        for (AldParser.RegularruleContext regularruleContext : ctx.regularrule())
            ruleSetNode.addRegularRule((RegularRuleNode) visit(regularruleContext));

        return ruleSetNode;

    }

    @Override
    public TreeNode visitRegularrule(AldParser.RegularruleContext ctx) {
        RegularRuleNode regularRuleNode = new RegularRuleNode();

        for (AldParser.AskContext askContext : ctx.ask()) {
            AskNode askNode = (AskNode) visit(askContext);
            regularRuleNode.addAsk(askNode);
        }

        for (AldParser.TellContext tellContext : ctx.tell()) {
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

        for (AldParser.TellContext tellContext : ctx.tell()) {
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
    public TreeNode visitStructureEqNode(AldParser.StructureEqNodeContext ctx) {

        String variableName = ctx.ID(0).getText();
        String structureName = ctx.ID(1).getText();

        List<ExpressionNode> exprs = new ArrayList<>();

        for(AldParser.ExprContext exprContext : ctx.expr())
            exprs.add((ExpressionNode) visit(exprContext));

        return new StructureNode(variableName, structureName, exprs);
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
    public TreeNode visitNEqNode(AldParser.NEqNodeContext ctx) {
        return super.visitNEqNode(ctx);
    }

    @Override
    public TreeNode visitDispatchNode(AldParser.DispatchNodeContext ctx) {
        List<ExpressionNode> exprs = new ArrayList<>();
        for (AldParser.ExprContext exprContext : ctx.expr())
            exprs.add((ExpressionNode) visit(exprContext));

        if (ctx.ID().size() == 1)
            return new DispatchNode(ctx.ID(0).getText(), exprs, null);
        return new DispatchNode(ctx.ID(0).getText(), exprs, ctx.ID(1).getText());
    }
}
