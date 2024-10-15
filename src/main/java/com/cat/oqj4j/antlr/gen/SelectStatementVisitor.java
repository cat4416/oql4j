// Generated from SelectStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SelectStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SelectStatementVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SelectStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(SelectStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectStatementParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(SelectStatementParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DirectSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectSelect(SelectStatementParser.DirectSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AliasSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasSelect(SelectStatementParser.AliasSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AsAliasSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsAliasSelect(SelectStatementParser.AsAliasSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVal(SelectStatementParser.StringValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberVal(SelectStatementParser.NumberValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanVal(SelectStatementParser.BooleanValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullVal(SelectStatementParser.NullValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldPlaceVal(SelectStatementParser.FieldPlaceValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunPlaceVal(SelectStatementParser.FunPlaceValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodPlaceVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodPlaceVal(SelectStatementParser.MethodPlaceValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListVal(SelectStatementParser.ListValContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectStatementParser#funPlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunPlace(SelectStatementParser.FunPlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectStatementParser#methodPlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodPlace(SelectStatementParser.MethodPlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldPlace(SelectStatementParser.FieldPlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectStatementParser#idNest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdNest(SelectStatementParser.IdNestContext ctx);
}