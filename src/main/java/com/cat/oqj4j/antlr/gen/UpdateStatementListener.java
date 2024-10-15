// Generated from UpdateStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UpdateStatementParser}.
 */
public interface UpdateStatementListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UpdateStatementParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(UpdateStatementParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateStatementParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(UpdateStatementParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(UpdateStatementParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(UpdateStatementParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseAssign}
	 * labeled alternative in {@link UpdateStatementParser#update}.
	 * @param ctx the parse tree
	 */
	void enterBaseAssign(UpdateStatementParser.BaseAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseAssign}
	 * labeled alternative in {@link UpdateStatementParser#update}.
	 * @param ctx the parse tree
	 */
	void exitBaseAssign(UpdateStatementParser.BaseAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateStatementParser#updateField}.
	 * @param ctx the parse tree
	 */
	void enterUpdateField(UpdateStatementParser.UpdateFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateStatementParser#updateField}.
	 * @param ctx the parse tree
	 */
	void exitUpdateField(UpdateStatementParser.UpdateFieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterStringVal(UpdateStatementParser.StringValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitStringVal(UpdateStatementParser.StringValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterNumberVal(UpdateStatementParser.NumberValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitNumberVal(UpdateStatementParser.NumberValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBooleanVal(UpdateStatementParser.BooleanValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBooleanVal(UpdateStatementParser.BooleanValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterNullVal(UpdateStatementParser.NullValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitNullVal(UpdateStatementParser.NullValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterFieldPlaceVal(UpdateStatementParser.FieldPlaceValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitFieldPlaceVal(UpdateStatementParser.FieldPlaceValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterFunPlaceVal(UpdateStatementParser.FunPlaceValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitFunPlaceVal(UpdateStatementParser.FunPlaceValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterMethodPlaceVal(UpdateStatementParser.MethodPlaceValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodPlaceVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitMethodPlaceVal(UpdateStatementParser.MethodPlaceValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterListVal(UpdateStatementParser.ListValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListVal}
	 * labeled alternative in {@link UpdateStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitListVal(UpdateStatementParser.ListValContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateStatementParser#funPlace}.
	 * @param ctx the parse tree
	 */
	void enterFunPlace(UpdateStatementParser.FunPlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateStatementParser#funPlace}.
	 * @param ctx the parse tree
	 */
	void exitFunPlace(UpdateStatementParser.FunPlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateStatementParser#methodPlace}.
	 * @param ctx the parse tree
	 */
	void enterMethodPlace(UpdateStatementParser.MethodPlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateStatementParser#methodPlace}.
	 * @param ctx the parse tree
	 */
	void exitMethodPlace(UpdateStatementParser.MethodPlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 */
	void enterFieldPlace(UpdateStatementParser.FieldPlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 */
	void exitFieldPlace(UpdateStatementParser.FieldPlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateStatementParser#idNest}.
	 * @param ctx the parse tree
	 */
	void enterIdNest(UpdateStatementParser.IdNestContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateStatementParser#idNest}.
	 * @param ctx the parse tree
	 */
	void exitIdNest(UpdateStatementParser.IdNestContext ctx);
}