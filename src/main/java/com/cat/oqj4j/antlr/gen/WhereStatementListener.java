// Generated from WhereStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhereStatementParser}.
 */
public interface WhereStatementListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhereStatementParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(WhereStatementParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhereStatementParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(WhereStatementParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpStat(WhereStatementParser.UnaryExpStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpStat(WhereStatementParser.UnaryExpStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterParenStat(WhereStatementParser.ParenStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitParenStat(WhereStatementParser.ParenStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAndStat(WhereStatementParser.AndStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAndStat(WhereStatementParser.AndStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpStat(WhereStatementParser.BinaryExpStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpStat(WhereStatementParser.BinaryExpStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterOrStat(WhereStatementParser.OrStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrStat}
	 * labeled alternative in {@link WhereStatementParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitOrStat(WhereStatementParser.OrStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryCond}
	 * labeled alternative in {@link WhereStatementParser#binaryExp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryCond(WhereStatementParser.BinaryCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryCond}
	 * labeled alternative in {@link WhereStatementParser#binaryExp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryCond(WhereStatementParser.BinaryCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhereStatementParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(WhereStatementParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhereStatementParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(WhereStatementParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterInCond(WhereStatementParser.InCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitInCond(WhereStatementParser.InCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BetweenCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterBetweenCond(WhereStatementParser.BetweenCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BetweenCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitBetweenCond(WhereStatementParser.BetweenCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterNullCond(WhereStatementParser.NullCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitNullCond(WhereStatementParser.NullCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotNullCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterNotNullCond(WhereStatementParser.NotNullCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotNullCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitNotNullCond(WhereStatementParser.NotNullCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterValCond(WhereStatementParser.ValCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValCond}
	 * labeled alternative in {@link WhereStatementParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitValCond(WhereStatementParser.ValCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterStringVal(WhereStatementParser.StringValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitStringVal(WhereStatementParser.StringValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterNumberVal(WhereStatementParser.NumberValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitNumberVal(WhereStatementParser.NumberValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBooleanVal(WhereStatementParser.BooleanValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBooleanVal(WhereStatementParser.BooleanValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterNullVal(WhereStatementParser.NullValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitNullVal(WhereStatementParser.NullValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterFieldPlaceVal(WhereStatementParser.FieldPlaceValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldPlaceVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitFieldPlaceVal(WhereStatementParser.FieldPlaceValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterFunPlaceVal(WhereStatementParser.FunPlaceValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunPlaceVal}
	 * labeled alternative in {@link WhereStatementParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitFunPlaceVal(WhereStatementParser.FunPlaceValContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhereStatementParser#funPlace}.
	 * @param ctx the parse tree
	 */
	void enterFunPlace(WhereStatementParser.FunPlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhereStatementParser#funPlace}.
	 * @param ctx the parse tree
	 */
	void exitFunPlace(WhereStatementParser.FunPlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhereStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 */
	void enterFieldPlace(WhereStatementParser.FieldPlaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhereStatementParser#fieldPlace}.
	 * @param ctx the parse tree
	 */
	void exitFieldPlace(WhereStatementParser.FieldPlaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhereStatementParser#idNest}.
	 * @param ctx the parse tree
	 */
	void enterIdNest(WhereStatementParser.IdNestContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhereStatementParser#idNest}.
	 * @param ctx the parse tree
	 */
	void exitIdNest(WhereStatementParser.IdNestContext ctx);
}