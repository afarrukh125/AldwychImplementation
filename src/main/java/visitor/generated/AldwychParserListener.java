package visitor.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AldwychParser}.
 */
public interface AldwychParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AldwychParser#aldwychClass}.
	 * @param ctx the parse tree
	 */
	void enterAldwychClass(AldwychParser.AldwychClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#aldwychClass}.
	 * @param ctx the parse tree
	 */
	void exitAldwychClass(AldwychParser.AldwychClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProcedureNode}
	 * labeled alternative in {@link AldwychParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureNode(AldwychParser.ProcedureNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProcedureNode}
	 * labeled alternative in {@link AldwychParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureNode(AldwychParser.ProcedureNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainProcedureNode}
	 * labeled alternative in {@link AldwychParser#mainprocedure}.
	 * @param ctx the parse tree
	 */
	void enterMainProcedureNode(AldwychParser.MainProcedureNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainProcedureNode}
	 * labeled alternative in {@link AldwychParser#mainprocedure}.
	 * @param ctx the parse tree
	 */
	void exitMainProcedureNode(AldwychParser.MainProcedureNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#heading}.
	 * @param ctx the parse tree
	 */
	void enterHeading(AldwychParser.HeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#heading}.
	 * @param ctx the parse tree
	 */
	void exitHeading(AldwychParser.HeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(AldwychParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(AldwychParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#formals}.
	 * @param ctx the parse tree
	 */
	void enterFormals(AldwychParser.FormalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#formals}.
	 * @param ctx the parse tree
	 */
	void exitFormals(AldwychParser.FormalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#readers}.
	 * @param ctx the parse tree
	 */
	void enterReaders(AldwychParser.ReadersContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#readers}.
	 * @param ctx the parse tree
	 */
	void exitReaders(AldwychParser.ReadersContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#writers}.
	 * @param ctx the parse tree
	 */
	void enterWriters(AldwychParser.WritersContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#writers}.
	 * @param ctx the parse tree
	 */
	void exitWriters(AldwychParser.WritersContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(AldwychParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(AldwychParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void enterRuleset(AldwychParser.RulesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void exitRuleset(AldwychParser.RulesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#regularrule}.
	 * @param ctx the parse tree
	 */
	void enterRegularrule(AldwychParser.RegularruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#regularrule}.
	 * @param ctx the parse tree
	 */
	void exitRegularrule(AldwychParser.RegularruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AskNode}
	 * labeled alternative in {@link AldwychParser#ask}.
	 * @param ctx the parse tree
	 */
	void enterAskNode(AldwychParser.AskNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AskNode}
	 * labeled alternative in {@link AldwychParser#ask}.
	 * @param ctx the parse tree
	 */
	void exitAskNode(AldwychParser.AskNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TellNode}
	 * labeled alternative in {@link AldwychParser#tell}.
	 * @param ctx the parse tree
	 */
	void enterTellNode(AldwychParser.TellNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TellNode}
	 * labeled alternative in {@link AldwychParser#tell}.
	 * @param ctx the parse tree
	 */
	void exitTellNode(AldwychParser.TellNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AldwychParser#finalrule}.
	 * @param ctx the parse tree
	 */
	void enterFinalrule(AldwychParser.FinalruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AldwychParser#finalrule}.
	 * @param ctx the parse tree
	 */
	void exitFinalrule(AldwychParser.FinalruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DispatchNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDispatchNode(AldwychParser.DispatchNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DispatchNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDispatchNode(AldwychParser.DispatchNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEmptyNode(AldwychParser.EmptyNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEmptyNode(AldwychParser.EmptyNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStructureEqNode(AldwychParser.StructureEqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStructureEqNode(AldwychParser.StructureEqNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGEqNode(AldwychParser.GEqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGEqNode(AldwychParser.GEqNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GTNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGTNode(AldwychParser.GTNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GTNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGTNode(AldwychParser.GTNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerNode(AldwychParser.IntegerNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerNode(AldwychParser.IntegerNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierNode(AldwychParser.IdentifierNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierNode(AldwychParser.IdentifierNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleEqualsNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleEqualsNode(AldwychParser.DoubleEqualsNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleEqualsNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleEqualsNode(AldwychParser.DoubleEqualsNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLEqNode(AldwychParser.LEqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLEqNode(AldwychParser.LEqNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivMultNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivMultNode(AldwychParser.DivMultNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivMultNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivMultNode(AldwychParser.DivMultNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusPlusNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinusPlusNode(AldwychParser.MinusPlusNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusPlusNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinusPlusNode(AldwychParser.MinusPlusNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqNode(AldwychParser.EqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqNode(AldwychParser.EqNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayNode(AldwychParser.ArrayNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayNode(AldwychParser.ArrayNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OutputStructureNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOutputStructureNode(AldwychParser.OutputStructureNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OutputStructureNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOutputStructureNode(AldwychParser.OutputStructureNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNEqNode(AldwychParser.NEqNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNEqNode(AldwychParser.NEqNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignNode(AldwychParser.AssignNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignNode(AldwychParser.AssignNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LTNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLTNode(AldwychParser.LTNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LTNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLTNode(AldwychParser.LTNodeContext ctx);
}