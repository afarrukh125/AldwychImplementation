package visitor;

import nodes.ClassNode;
import nodes.TreeNode;

/**
 * Used to build our tree to then execute afterwards
 * This is done as a frontend step
 */
public class AldTreeBuilder extends AldParserBaseVisitor<TreeNode> {

    @Override
    public TreeNode visitAldwychClass(AldParser.AldwychClassContext ctx) {
        ClassNode classNode = new ClassNode();

        for(AldParser.DeclarationContext decl : ctx.declaration())
            classNode.addChild(visit(decl));

        return classNode;
    }

    @Override
    public TreeNode visitProcedureNode(AldParser.ProcedureNodeContext ctx) {
        return super.visitProcedureNode(ctx);
    }

    @Override
    public TreeNode visitDeclarationNode(AldParser.DeclarationNodeContext ctx) {
        return super.visitDeclarationNode(ctx);
    }

    @Override
    public TreeNode visitHeading(AldParser.HeadingContext ctx) {
        return super.visitHeading(ctx);
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
        return super.visitReader(ctx);
    }

    @Override
    public TreeNode visitWriter(AldParser.WriterContext ctx) {
        return super.visitWriter(ctx);
    }

    @Override
    public TreeNode visitBody(AldParser.BodyContext ctx) {
        return super.visitBody(ctx);
    }

    @Override
    public TreeNode visitRegularrule(AldParser.RegularruleContext ctx) {
        return super.visitRegularrule(ctx);
    }

    @Override
    public TreeNode visitAsk(AldParser.AskContext ctx) {
        return super.visitAsk(ctx);
    }

    @Override
    public TreeNode visitTellAssignNode(AldParser.TellAssignNodeContext ctx) {
        return super.visitTellAssignNode(ctx);
    }

    @Override
    public TreeNode visitTellNode(AldParser.TellNodeContext ctx) {
        return super.visitTellNode(ctx);
    }

    @Override
    public TreeNode visitFinalrule(AldParser.FinalruleContext ctx) {
        return super.visitFinalrule(ctx);
    }

    @Override
    public TreeNode visitLtNode(AldParser.LtNodeContext ctx) {
        return super.visitLtNode(ctx);
    }

    @Override
    public TreeNode visitStringConstNode(AldParser.StringConstNodeContext ctx) {
        return super.visitStringConstNode(ctx);
    }

    @Override
    public TreeNode visitGEqNode(AldParser.GEqNodeContext ctx) {
        return super.visitGEqNode(ctx);
    }

    @Override
    public TreeNode visitGTNode(AldParser.GTNodeContext ctx) {
        return super.visitGTNode(ctx);
    }

    @Override
    public TreeNode visitDivMultNode(AldParser.DivMultNodeContext ctx) {
        return super.visitDivMultNode(ctx);
    }

    @Override
    public TreeNode visitMinusPlusNode(AldParser.MinusPlusNodeContext ctx) {
        return super.visitMinusPlusNode(ctx);
    }

    @Override
    public TreeNode visitIntegerNode(AldParser.IntegerNodeContext ctx) {
        return super.visitIntegerNode(ctx);
    }

    @Override
    public TreeNode visitEqNode(AldParser.EqNodeContext ctx) {
        return super.visitEqNode(ctx);
    }

    @Override
    public TreeNode visitIdentifierNode(AldParser.IdentifierNodeContext ctx) {
        return super.visitIdentifierNode(ctx);
    }

    @Override
    public TreeNode visitTrue(AldParser.TrueContext ctx) {
        return super.visitTrue(ctx);
    }

    @Override
    public TreeNode visitFalse(AldParser.FalseContext ctx) {
        return super.visitFalse(ctx);
    }

    @Override
    public TreeNode visitLEqNode(AldParser.LEqNodeContext ctx) {
        return super.visitLEqNode(ctx);
    }
}
