// Generated from UpdateStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UpdateStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UpdateStatementVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UpdateStatementParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(UpdateStatementParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateStatementParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(UpdateStatementParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseAssign}
	 * labeled alternative in {@link UpdateStatementParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseAssign(UpdateStatementParser.BaseAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateStatementParser#updateField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateField(UpdateStatementParser.UpdateFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVal(UpdateStatementParser.StringValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberVal(UpdateStatementParser.NumberValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanVal(UpdateStatementParser.BooleanValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullVal(UpdateStatementParser.NullValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldPlaceVal(UpdateStatementParser.FieldPlaceValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunPlaceVal(UpdateStatementParser.FunPlaceValContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateStatementParser#funPlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunPlace(UpdateStatementParser.FunPlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldPlace(UpdateStatementParser.FieldPlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateStatementParser#idNest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdNest(UpdateStatementParser.IdNestContext ctx);
}