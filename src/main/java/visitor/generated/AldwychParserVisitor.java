package visitor.generated;// Generated from AldwychParser.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AldwychParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AldwychParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AldwychParser#aldwychClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAldwychClass(AldwychParser.AldwychClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProcedureNode}
	 * labeled alternative in {@link AldwychParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureNode(AldwychParser.ProcedureNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainProcedureNode}
	 * labeled alternative in {@link AldwychParser#mainprocedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainProcedureNode(AldwychParser.MainProcedureNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#heading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeading(AldwychParser.HeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(AldwychParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#formals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormals(AldwychParser.FormalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#readers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReaders(AldwychParser.ReadersContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#writers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriters(AldwychParser.WritersContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(AldwychParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#ruleset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleset(AldwychParser.RulesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#regularrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularrule(AldwychParser.RegularruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AskNode}
	 * labeled alternative in {@link AldwychParser#ask}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAskNode(AldwychParser.AskNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TellNode}
	 * labeled alternative in {@link AldwychParser#tell}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTellNode(AldwychParser.TellNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldwychParser#finalrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalrule(AldwychParser.FinalruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DispatchNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatchNode(AldwychParser.DispatchNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureEqNode(AldwychParser.StructureEqNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGEqNode(AldwychParser.GEqNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GTNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGTNode(AldwychParser.GTNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerNode(AldwychParser.IntegerNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierNode(AldwychParser.IdentifierNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleEqualsNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleEqualsNode(AldwychParser.DoubleEqualsNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLEqNode(AldwychParser.LEqNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringConstNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstNode(AldwychParser.StringConstNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivMultNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivMultNode(AldwychParser.DivMultNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusPlusNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusPlusNode(AldwychParser.MinusPlusNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNode(AldwychParser.EqNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractableArrayNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractableArrayNode(AldwychParser.ExtractableArrayNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayNode(AldwychParser.ArrayNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OutputStructureNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputStructureNode(AldwychParser.OutputStructureNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEqNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEqNode(AldwychParser.NEqNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignNode(AldwychParser.AssignNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LTNode}
	 * labeled alternative in {@link AldwychParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLTNode(AldwychParser.LTNodeContext ctx);
}