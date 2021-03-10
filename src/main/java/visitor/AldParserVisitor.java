package visitor;// Generated from AldParser.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AldParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AldParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AldParser#aldwychClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAldwychClass(AldParser.AldwychClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProcedureNode}
	 * labeled alternative in {@link AldParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureNode(AldParser.ProcedureNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SequentialProcedureNode}
	 * labeled alternative in {@link AldParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequentialProcedureNode(AldParser.SequentialProcedureNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationNode}
	 * labeled alternative in {@link AldParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationNode(AldParser.DeclarationNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#seqbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqbody(AldParser.SeqbodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#heading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeading(AldParser.HeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(AldParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#formals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormals(AldParser.FormalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#readers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReaders(AldParser.ReadersContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#writers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriters(AldParser.WritersContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(AldParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#ruleset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleset(AldParser.RulesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#regularrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularrule(AldParser.RegularruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AskNode}
	 * labeled alternative in {@link AldParser#ask}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAskNode(AldParser.AskNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TellNode}
	 * labeled alternative in {@link AldParser#tell}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTellNode(AldParser.TellNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#finalrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalrule(AldParser.FinalruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DispatchNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatchNode(AldParser.DispatchNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GEqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGEqNode(AldParser.GEqNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GTNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGTNode(AldParser.GTNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerNode(AldParser.IntegerNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierNode(AldParser.IdentifierNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(AldParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(AldParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LEqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLEqNode(AldParser.LEqNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LtNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtNode(AldParser.LtNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringConstNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstNode(AldParser.StringConstNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivMultNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivMultNode(AldParser.DivMultNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusPlusNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusPlusNode(AldParser.MinusPlusNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNode(AldParser.EqNodeContext ctx);
}