package visitor;

import nodes.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

import static visitor.customised.ExecutionVisitor.STRUCTURE_IDENTIFIER;

/**
 * Used to build our tree to then execute afterwards
 * This is done as a frontend step
 */
public class TreeBuilder extends AldwychParserBaseVisitor<TreeNode> {

    @Override
    public TreeNode visitAldwychClass(AldwychParser.AldwychClassContext ctx) {

        // One sequential procedure per class
        AldwychParser.MainprocedureContext mainProcedureContext = ctx.mainprocedure();

        MainProcedureNode seqProcedureResult = (MainProcedureNode) visit(mainProcedureContext);
        ClassNode classNode = new ClassNode(seqProcedureResult);

        for (AldwychParser.DeclarationContext decl : ctx.declaration()) {
            TreeNode result = visit(decl);
            if (decl instanceof AldwychParser.ProcedureNodeContext)
                classNode.addProcedureNode((ProcedureNode) result);
        }

        return classNode;
    }

    @Override
    public TreeNode visitProcedureNode(AldwychParser.ProcedureNodeContext ctx) {
        HeadingNode headingNode = (HeadingNode) visit(ctx.heading());
        BodyNode bodyNode = (BodyNode) visit(ctx.body());
        return new ProcedureNode(headingNode, bodyNode);
    }

    @Override
    public TreeNode visitHeading(AldwychParser.HeadingContext ctx) {
        ReaderContainerNode readers = (ReaderContainerNode) visit(ctx.formals().readers());
        WriterContainerNode writers = (WriterContainerNode) visit(ctx.formals().writers());

        HeadingNode node = new HeadingNode(ctx.name().ID().getText(), readers, writers);
        return node;
    }

    @Override
    public TreeNode visitName(AldwychParser.NameContext ctx) {
        return super.visitName(ctx);
    }

    @Override
    public TreeNode visitFormals(AldwychParser.FormalsContext ctx) {
        return super.visitFormals(ctx);
    }

    @Override
    public TreeNode visitReaders(AldwychParser.ReadersContext ctx) {
        ReaderContainerNode readers = new ReaderContainerNode();

        for (TerminalNode tn : ctx.ID())
            readers.addReader(new ReaderNode(tn.getText()));

        return readers;
    }

    @Override
    public TreeNode visitWriters(AldwychParser.WritersContext ctx) {
        WriterContainerNode writers = new WriterContainerNode();

        for (TerminalNode writer : ctx.ID())
            writers.addWriter(new WriterNode(writer.getText()));

        return writers;
    }

    @Override
    public TreeNode visitMainProcedureNode(AldwychParser.MainProcedureNodeContext ctx) {
        HeadingNode headingNode = (HeadingNode) visit(ctx.heading());
        FinalRuleNode finalRuleNode = (FinalRuleNode) visit(ctx.finalrule());
        return new MainProcedureNode(headingNode, finalRuleNode);
    }

    @Override
    public TreeNode visitBody(AldwychParser.BodyContext ctx) {
        BodyNode bodyNode = new BodyNode();

        for (AldwychParser.RulesetContext rulesetContext : ctx.ruleset())
            bodyNode.addRuleSet((RuleSetNode) visit(rulesetContext));

        bodyNode.setFinalRule((FinalRuleNode) visit(ctx.finalrule()));
        return bodyNode;
    }

    @Override
    public TreeNode visitRuleset(AldwychParser.RulesetContext ctx) {

        RuleSetNode ruleSetNode = new RuleSetNode();

        for (AldwychParser.RegularruleContext regularruleContext : ctx.regularrule())
            ruleSetNode.addRegularRule((RegularRuleNode) visit(regularruleContext));

        return ruleSetNode;

    }

    @Override
    public TreeNode visitRegularrule(AldwychParser.RegularruleContext ctx) {
        RegularRuleNode regularRuleNode = new RegularRuleNode();

        for (AldwychParser.AskContext askContext : ctx.ask()) {
            AskNode askNode = (AskNode) visit(askContext);
            regularRuleNode.addAsk(askNode);
        }

        for (AldwychParser.TellContext tellContext : ctx.tell()) {
            TellNode tellNode = (TellNode) visit(tellContext);
            regularRuleNode.addTell(tellNode);
        }

        return regularRuleNode;
    }

    @Override
    public TreeNode visitAskNode(AldwychParser.AskNodeContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode) visit(ctx.expr());
        return new AskNode(expressionNode);
    }

    @Override
    public TreeNode visitTellNode(AldwychParser.TellNodeContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode) visit(ctx.expr());
        return new TellNode(expressionNode);
    }

    @Override
    public TreeNode visitFinalrule(AldwychParser.FinalruleContext ctx) {
        FinalRuleNode node = new FinalRuleNode();

        for (AldwychParser.TellContext tellContext : ctx.tell()) {
            TellNode tellNode = (TellNode) visit(tellContext);
            node.addTell(tellNode);
        }
        return node;
    }

    @Override
    public TreeNode visitLTNode(AldwychParser.LTNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new LTNode(left, right);
    }

    @Override
    public TreeNode visitOutputStructureNode(AldwychParser.OutputStructureNodeContext ctx) {
        // TODO implement
        return super.visitOutputStructureNode(ctx);
    }

    @Override
    public TreeNode visitGEqNode(AldwychParser.GEqNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new GEqNode(left, right);
    }

    @Override
    public TreeNode visitGTNode(AldwychParser.GTNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new GTNode(left, right);
    }

    @Override
    public TreeNode visitDivMultNode(AldwychParser.DivMultNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        if (ctx.DIV_OPERATOR() != null)
            return new DivNode(left, right);
        return new MulNode(left, right);
    }

    @Override
    public TreeNode visitMinusPlusNode(AldwychParser.MinusPlusNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        if (ctx.MINUS_OPERATOR() != null)
            return new SubNode(left, right);
        return new PlusNode(left, right);
    }

    @Override
    public TreeNode visitStructureEqNode(AldwychParser.StructureEqNodeContext ctx) {

        String variableName = ctx.ID(0).getText();
        String structureName = ctx.ID(1).getText();

        List<ExpressionNode> exprs = new ArrayList<>();

        for(AldwychParser.ExprContext exprContext : ctx.expr())
            exprs.add((ExpressionNode) visit(exprContext));

        return new StructureNode(variableName, structureName, exprs);
    }

    @Override
    public TreeNode visitIntegerNode(AldwychParser.IntegerNodeContext ctx) {
        return new IntegerNode(ctx.getText());
    }

    @Override
    public TreeNode visitEqNode(AldwychParser.EqNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));
        return new EqNode(left, right);
    }

    @Override
    public TreeNode visitDoubleEqualsNode(AldwychParser.DoubleEqualsNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));
        return new DoubleEqualsNode(left, right);
    }

    @Override
    public TreeNode visitAssignNode(AldwychParser.AssignNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));
        return new AssignNode(left, right);
    }

    @Override
    public TreeNode visitIdentifierNode(AldwychParser.IdentifierNodeContext ctx) {
        return new IdentifierNode(ctx.ID().getText());
    }

    @Override
    public TreeNode visitLEqNode(AldwychParser.LEqNodeContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.expr(0));
        ExpressionNode right = (ExpressionNode) visit(ctx.expr(1));

        return new LEqNode(left, right);
    }

    @Override
    public TreeNode visitNEqNode(AldwychParser.NEqNodeContext ctx) {
        return super.visitNEqNode(ctx);
    }

    @Override
    public TreeNode visitDispatchNode(AldwychParser.DispatchNodeContext ctx) {
        List<ExpressionNode> exprs = new ArrayList<>();
        for (AldwychParser.ExprContext exprContext : ctx.expr())
            exprs.add((ExpressionNode) visit(exprContext));

        if (ctx.ID().size() == 1)
            return new DispatchNode(ctx.ID(0).getText(), exprs, null);
        return new DispatchNode(ctx.ID(0).getText(), exprs, ctx.ID(1).getText());
    }

    private static int structureCounter = 0;
    private static final String HIDDEN_VAR_PREFIX = "WQ";
    @Override
    public TreeNode visitArrayNode(AldwychParser.ArrayNodeContext ctx) {
        // An array is essentially just sequential structures
        StructureNode constituentStructure = new EmptyStructureNode();
        int structCount = ctx.expr().size() + structureCounter;
        structureCounter += structCount;
        List<AldwychParser.ExprContext> exprs = ctx.expr();

        for (int i = exprs.size()-1; i >=0; i--) {
            List<ExpressionNode> expressionNodes = new ArrayList<>();
            expressionNodes.add((ExpressionNode) visit(ctx.expr(i)));
            expressionNodes.add(constituentStructure);
            constituentStructure = new StructureNode(HIDDEN_VAR_PREFIX + structCount-- + STRUCTURE_IDENTIFIER, "list", expressionNodes);
        }

        return constituentStructure;
    }
}
