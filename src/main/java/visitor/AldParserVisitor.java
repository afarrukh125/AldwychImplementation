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
	 * Visit a parse tree produced by {@link AldParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(AldParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(AldParser.ProcedureContext ctx);
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
	 * Visit a parse tree produced by {@link AldParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(AldParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#reader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReader(AldParser.ReaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#writer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriter(AldParser.WriterContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(AldParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#regularrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularrule(AldParser.RegularruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AldParser#ask}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsk(AldParser.AskContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TellAssignNode}
	 * labeled alternative in {@link AldParser#tell}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTellAssignNode(AldParser.TellAssignNodeContext ctx);
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
	 * Visit a parse tree produced by the {@code IntegerNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerNode(AldParser.IntegerNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqNode}
	 * labeled alternative in {@link AldParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNode(AldParser.EqNodeContext ctx);
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
}