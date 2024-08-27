// Generated from WhereStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhereStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhereStatementVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhereStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(WhereStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpStat(WhereStatementParser.UnaryExpStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenStat(WhereStatementParser.ParenStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndStat(WhereStatementParser.AndStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpStat(WhereStatementParser.BinaryExpStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrStat(WhereStatementParser.OrStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryCond}
	 * labeled alternative in {@link WhereStatementParser#binaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryCond(WhereStatementParser.BinaryCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhereStatementParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(WhereStatementParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCond(WhereStatementParser.InCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BetweenCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenCond(WhereStatementParser.BetweenCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCond(WhereStatementParser.NullCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotNullCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullCond(WhereStatementParser.NotNullCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValCond(WhereStatementParser.ValCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVal(WhereStatementParser.StringValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberVal(WhereStatementParser.NumberValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanVal(WhereStatementParser.BooleanValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullVal(WhereStatementParser.NullValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldPlaceVal(WhereStatementParser.FieldPlaceValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunPlaceVal(WhereStatementParser.FunPlaceValContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhereStatementParser#funPlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunPlace(WhereStatementParser.FunPlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhereStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldPlace(WhereStatementParser.FieldPlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhereStatementParser#idNest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdNest(WhereStatementParser.IdNestContext ctx);
}