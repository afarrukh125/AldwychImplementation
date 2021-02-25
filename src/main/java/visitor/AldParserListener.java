package visitor;// Generated from AldParser.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AldParser}.
 */
public interface AldParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AldParser#aldwychClass}.
	 * @param ctx the parse tree
	 */
	void enterAldwychClass(AldParser.AldwychClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#aldwychClass}.
	 * @param ctx the parse tree
	 */
	void exitAldwychClass(AldParser.AldwychClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(AldParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(AldParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(AldParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(AldParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#heading}.
	 * @param ctx the parse tree
	 */
	void enterHeading(AldParser.HeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#heading}.
	 * @param ctx the parse tree
	 */
	void exitHeading(AldParser.HeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(AldParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(AldParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(AldParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(AldParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#reader}.
	 * @param ctx the parse tree
	 */
	void enterReader(AldParser.ReaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#reader}.
	 * @param ctx the parse tree
	 */
	void exitReader(AldParser.ReaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#writer}.
	 * @param ctx the parse tree
	 */
	void enterWriter(AldParser.WriterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#writer}.
	 * @param ctx the parse tree
	 */
	void exitWriter(AldParser.WriterContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(AldParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(AldParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#regularrule}.
	 * @param ctx the parse tree
	 */
	void enterRegularrule(AldParser.RegularruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#regularrule}.
	 * @param ctx the parse tree
	 */
	void exitRegularrule(AldParser.RegularruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#ask}.
	 * @param ctx the parse tree
	 */
	void enterAsk(AldParser.AskContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#ask}.
	 * @param ctx the parse tree
	 */
	void exitAsk(AldParser.AskContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TellAssignNode}
	 * labeled alternative in {@link AldParser#tell}.
	 * @param ctx the parse tree
	 */
	void enterTellAssignNode(AldParser.TellAssignNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TellAssignNode}
	 * labeled alternative in {@link AldParser#tell}.
	 * @param ctx the parse tree
	 */
	void exitTellAssignNode(AldParser.TellAssignNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TellNode}
	 * labeled alternative in {@link AldParser#tell}.
	 * @param ctx the parse tree
	 */
	void enterTellNode(AldParser.TellNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TellNode}
	 * labeled alternative in {@link AldParser#tell}.
	 * @param ctx the parse tree
	 */
	void exitTellNode(AldParser.TellNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldParser#finalrule}.
	 * @param ctx the parse tree
	 */
	void enterFinalrule(AldParser.FinalruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldParser#finalrule}.
	 * @param ctx the parse tree
	 */
	void exitFinalrule(AldParser.FinalruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LtNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLtNode(AldParser.LtNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LtNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLtNode(AldParser.LtNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringConstNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringConstNode(AldParser.StringConstNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringConstNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringConstNode(AldParser.StringConstNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GEqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGEqNode(AldParser.GEqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GEqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGEqNode(AldParser.GEqNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GTNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGTNode(AldParser.GTNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GTNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGTNode(AldParser.GTNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivMultNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivMultNode(AldParser.DivMultNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivMultNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivMultNode(AldParser.DivMultNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusPlusNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinusPlusNode(AldParser.MinusPlusNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusPlusNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinusPlusNode(AldParser.MinusPlusNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerNode(AldParser.IntegerNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerNode(AldParser.IntegerNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqNode(AldParser.EqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqNode(AldParser.EqNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierNode(AldParser.IdentifierNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierNode(AldParser.IdentifierNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrue(AldParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrue(AldParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalse(AldParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalse(AldParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LEqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLEqNode(AldParser.LEqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LEqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLEqNode(AldParser.LEqNodeContext ctx);
}