package visitor;  

import helpers.*;
import helpers.rules.*;
import nodes.BooleanNode;
import nodes.IdentifierNode;
import nodes.IntegerNode;
import nodes.StringConstNode;

/**
 * This visitor aims to build an image of our variables values, so that we can execute statements in parallel
 */
public class RuleBuildVisitor extends AldParserBaseVisitor<Object> {

    private final SymbolTable symbolTable;

    public RuleBuildVisitor() {
        symbolTable = new SymbolTable();
    }

    @Override
    public Object visitAldwychClass(AldParser.AldwychClassContext ctx) {
        symbolTable.enterScope();
        return super.visitAldwychClass(ctx);
    }

    @Override
    public Object visitDeclaration(AldParser.DeclarationContext ctx) {

        if(ctx.expr() != null) {
            Object result = visit(ctx.expr());
            symbolTable.addVariable(ctx.ID().getText(), result);
        }
        return super.visitDeclaration(ctx);
    }

    @Override
    public Object visitProcedure(AldParser.ProcedureContext ctx) {
        symbolTable.enterScope();
        visit(ctx.heading());
        Object result = visit(ctx.body());
        symbolTable.exitScope();
        return result;
    }

    @Override
    public Object visitHeading(AldParser.HeadingContext ctx) {
        System.out.println("Visiting " + ctx.name().getText());
        return super.visitHeading(ctx);
    }

    @Override
    public Object visitName(AldParser.NameContext ctx) {
        return super.visitName(ctx);
    }

    @Override
    public Object visitVariables(AldParser.VariablesContext ctx) {
        return super.visitVariables(ctx);
    }

    @Override
    public Object visitReader(AldParser.ReaderContext ctx) {
        return super.visitReader(ctx);
    }

    @Override
    public Object visitWriter(AldParser.WriterContext ctx) {
        return super.visitWriter(ctx);
    }

    private Rule generateFinalRule(AldParser.FinalruleContext ctx) {
        BooleanNode tellLeft = (BooleanNode) visit(ctx.tell());
        Object tellRight = visit(ctx.tell().expr(1));

        Tell tell = new Tell(tellLeft, tellRight);
        return RuleSet.from(tell);
    }

    private Rule generateRuleFromContext(AldParser.RegularruleContext ruleContext) {
        String askLeft = (String) visit(ruleContext.ask().expr(0));
        Object askRight = visit(ruleContext.ask().expr(1));

        String tellLeft = (String) visit(ruleContext.tell().expr(0));
        Object tellRight = visit(ruleContext.tell().expr(1));

        Ask ask = new Ask(askLeft, askRight);
        Tell tell = new Tell(tellLeft, tellRight);
        return RuleSet.from(ask, tell);
    }

    @Override
    public Object visitBody(AldParser.BodyContext ctx) {
        Object result = super.visitBody(ctx);

        // Our collection of rules
        RuleSet ruleSet = new RuleSet();

        // Go through all the rules and build up our rule objects so we can run them concurrently right after
        for(AldParser.RegularruleContext ruleContext : ctx.regularrule())
            ruleSet.addRule(generateRuleFromContext(ruleContext));

        // Generate our final rule in case the others do not succeed
        Rule finalRule = generateFinalRule(ctx.finalrule());

        // Temporarily put in, to check which rules were added
        System.out.println("Rules generated: ");
        for(Rule rule : ruleSet)
            System.out.println(rule);

        System.out.println(finalRule);

        // Obtain the rule that was actually completed among all of those that were in the set after execution
        RuleData ruleToExecute = ruleSet.executeAll(symbolTable, finalRule);

        System.out.println("\nRule that was executed: " + ruleToExecute);
        System.out.println("The value of writer variable " + ruleToExecute.getRule().getTell().getLeft() + " was "
                + ruleToExecute.getPreviousValue() +
                " and is now " + symbolTable.findInScope(ruleToExecute.getRule().getTell().getRight().toString()));

        return result;
    }

    @Override
    public Object visitRegularrule(AldParser.RegularruleContext ctx) {
        return super.visitRegularrule(ctx);
    }

    @Override
    public Object visitAsk(AldParser.AskContext ctx) {
        return super.visitAsk(ctx);
    }

    @Override
    public Object visitTellAssignNode(AldParser.TellAssignNodeContext ctx) {
        return super.visitTellAssignNode(ctx);
    }

    @Override
    public Object visitTellNode(AldParser.TellNodeContext ctx) {
        return super.visitTellNode(ctx);
    }

    @Override
    public Object visitFinalrule(AldParser.FinalruleContext ctx) {
        return super.visitFinalrule(ctx);
    }

    @Override
    public Object visitLEqNode(AldParser.LEqNodeContext ctx) {
        IntegerNode leftInt = (IntegerNode) visit(ctx.expr(0));
        IntegerNode rightInt = (IntegerNode) visit(ctx.expr(1));

        boolean result = leftInt.getNodeValue() <= rightInt.getNodeValue();

        return new BooleanNode(result);
    }


    @Override
    public Object visitEqNode(AldParser.EqNodeContext ctx) {
        IntegerNode leftInt = (IntegerNode) visit(ctx.expr(0));
        IntegerNode rightInt = (IntegerNode) visit(ctx.expr(1));

        boolean result = leftInt.getNodeValue().equals(rightInt.getNodeValue());

        return new BooleanNode(result);
    }

    @Override
    public Object visitLtNode(AldParser.LtNodeContext ctx) {
        IntegerNode leftInt = (IntegerNode) visit(ctx.expr(0));
        IntegerNode rightInt = (IntegerNode) visit(ctx.expr(1));

        boolean result = leftInt.getNodeValue() < rightInt.getNodeValue();

        return new BooleanNode(result);
    }

    @Override
    public Object visitStringConstNode(AldParser.StringConstNodeContext ctx) {
        return new StringConstNode(ctx.getText());
    }

    @Override
    public Object visitGEqNode(AldParser.GEqNodeContext ctx) {
        IntegerNode leftInt = (IntegerNode) visit(ctx.expr(0));
        IntegerNode rightInt = (IntegerNode) visit(ctx.expr(1));

        boolean result = leftInt.getNodeValue() >= rightInt.getNodeValue();

        return new BooleanNode(result);
    }

    @Override
    public Object visitGTNode(AldParser.GTNodeContext ctx) {
        IntegerNode leftInt = (IntegerNode) visit(ctx.expr(0));
        IntegerNode rightInt = (IntegerNode) visit(ctx.expr(1));

        boolean result = leftInt.getNodeValue() > rightInt.getNodeValue();

        return new BooleanNode(result);
    }

    @Override
    public Object visitDivMultNode(AldParser.DivMultNodeContext ctx) {
        IntegerNode leftInt = (IntegerNode) visit(ctx.expr(0));
        IntegerNode rightInt = (IntegerNode) visit(ctx.expr(1));

        int result = 0;

        if(ctx.DIV_OPERATOR() != null)
            result = leftInt.getNodeValue() / rightInt.getNodeValue();

        if(ctx.MULT_OPERATOR() != null)
            result = leftInt.getNodeValue() * rightInt.getNodeValue();

        return new IntegerNode(result);
    }

    @Override
    public Object visitMinusPlusNode(AldParser.MinusPlusNodeContext ctx) {
        IntegerNode leftInt = (IntegerNode) visit(ctx.expr(0));
        IntegerNode rightInt = (IntegerNode) visit(ctx.expr(1));

        int result = 0;

        if(ctx.MINUS_OPERATOR() != null)
            result = leftInt.getNodeValue() - rightInt.getNodeValue();

        if(ctx.PLUS_OPERATOR() != null)
            result = leftInt.getNodeValue() + rightInt.getNodeValue();

        return new IntegerNode(result);
    }

    @Override
    public Object visitIntegerNode(AldParser.IntegerNodeContext ctx) {
        return new IntegerNode(ctx.getText());
    }

    @Override
    public Object visitIdentifierNode(AldParser.IdentifierNodeContext ctx) {
        return super.visitIdentifierNode(ctx);
    }

    @Override
    public Object visitTrue(AldParser.TrueContext ctx) {
        return new BooleanNode(true);
    }

    @Override
    public Object visitFalse(AldParser.FalseContext ctx) {
        return new BooleanNode(false);
    }
}
