// Generated from SelectStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SelectStatementParser}.
 */
public interface SelectStatementListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SelectStatementParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(SelectStatementParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectStatementParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(SelectStatementParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(SelectStatementParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(SelectStatementParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DirectSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 */
	void enterDirectSelect(SelectStatementParser.DirectSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DirectSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 */
	void exitDirectSelect(SelectStatementParser.DirectSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AliasSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 */
	void enterAliasSelect(SelectStatementParser.AliasSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AliasSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 */
	void exitAliasSelect(SelectStatementParser.AliasSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AsAliasSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 */
	void enterAsAliasSelect(SelectStatementParser.AsAliasSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AsAliasSelect}
	 * labeled alternative in {@link SelectStatementParser#select}.
	 * @param ctx the parse tree
	 */
	void exitAsAliasSelect(SelectStatementParser.AsAliasSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterStringVal(SelectStatementParser.StringValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitStringVal(SelectStatementParser.StringValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterNumberVal(SelectStatementParser.NumberValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitNumberVal(SelectStatementParser.NumberValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBooleanVal(SelectStatementParser.BooleanValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBooleanVal(SelectStatementParser.BooleanValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterNullVal(SelectStatementParser.NullValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitNullVal(SelectStatementParser.NullValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterFieldPlaceVal(SelectStatementParser.FieldPlaceValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitFieldPlaceVal(SelectStatementParser.FieldPlaceValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterFunPlaceVal(SelectStatementParser.FunPlaceValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link SelectStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitFunPlaceVal(SelectStatementParser.FunPlaceValContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectStatementParser#funPlace}.
	 * @param ctx the parse tree
	 */
	void enterFunPlace(SelectStatementParser.FunPlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectStatementParser#funPlace}.
	 * @param ctx the parse tree
	 */
	void exitFunPlace(SelectStatementParser.FunPlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 */
	void enterFieldPlace(SelectStatementParser.FieldPlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 */
	void exitFieldPlace(SelectStatementParser.FieldPlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectStatementParser#idNest}.
	 * @param ctx the parse tree
	 */
	void enterIdNest(SelectStatementParser.IdNestContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectStatementParser#idNest}.
	 * @param ctx the parse tree
	 */
	void exitIdNest(SelectStatementParser.IdNestContext ctx);
}