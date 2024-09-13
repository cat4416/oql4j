package com.cat.oqj4j.antlr.listener;

import com.cat.oqj4j.antlr.gen.WhereStatementBaseListener;
import com.cat.oqj4j.antlr.gen.WhereStatementParser;
import com.cat.oqj4j.antlr.handler.*;
import com.cat.oqj4j.antlr.type.*;
import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.LegalObjPack;
import com.cat.oqj4j.support.StrHelper;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

/**
 * where表达式监听器
 *
 * @author gwj
 */
public class WhereStatementListener<T> extends WhereStatementBaseListener {
    /**
     * 逗号分隔符
     */
    private final static String COMMA_SEPARATOR = ",";
    /**
     * 左括号标识符
     */
    private final static String LEFT_PARENTHESIS = "(";
    /**
     * 右括号标识符
     */
    private final static String RIGHT_PARENTHESIS = ")";

    /**
     * oql核心剖面
     */
    private final OqlCoreProfile coreProfile;
    /**
     * 节点栈
     */
    private final Deque<ExpType> nodeStack = new LinkedList<>();
    /**
     * 操作原对象集合
     */
    private final Collection<T> srcCol;
    /**
     * 合法对象栈。用于存放符合条件的对象。
     */
    private final Deque<LegalObjPack> legalObjStack = new LinkedList<>();
    /**
     * 是否已取出结果
     */
    private boolean isAlreadFetchResult;
    /**
     * 构造对象
     * @param coreProfile 核销剖面
     * @param srcCol 原对象
     */
    public WhereStatementListener(OqlCoreProfile coreProfile, Collection<T> srcCol) {
        if (srcCol == null) {
            throw new IllegalArgumentException("操作集合不能为空");
        }
        this.coreProfile = coreProfile;
        this.srcCol = srcCol;
    }

    @Override
    public void exitUnaryExpStat(WhereStatementParser.UnaryExpStatContext ctx) {
        // 格式: baseType unaryCond
        handleExpStat();
    }


    @Override
    public void exitBinaryExpStat(WhereStatementParser.BinaryExpStatContext ctx) {
        // 格式: left binaryCond right
        handleExpStat();
    }

    /**
     * 处理表达式语句
     */
    private void handleExpStat() {
        ExpType condExpType = nodeStack.pop();
        CondHandler condHandler = coreProfile.fetchCondHandler((Class<? extends CondExpType>) condExpType.getClass());
        if (condHandler == null) {
            throw new OqlExpResolvedException(condExpType.getExp() + " 表达式无对应的条件处理器");
        }

        LegalObjPack legalObjPack = condHandler.handleCond((CondExpType) condExpType, nodeStack, srcCol);
        // 入栈
        legalObjStack.push(legalObjPack);
    }


    @Override
    public void exitAndStat(WhereStatementParser.AndStatContext ctx) {
        // 格式: stat and stat
        LegalObjPack statResult01 = legalObjStack.pop();
        LegalObjPack statResult02 = legalObjStack.pop();
        LegalObjPack mergeResult = intersectLegalObjPack(statResult01, statResult02);
        // 入栈并集结果
        legalObjStack.push(mergeResult);
    }


    /**
     * 交集 封装的合法对象
     * @param p1 对象1
     * @param p2 对象2
     * @return
     */
    private LegalObjPack intersectLegalObjPack(LegalObjPack p1, LegalObjPack p2) {
        LegalObjPack intersectResult = new LegalObjPack();
        // 如果两个都全部符合的情况，则交集也是全部符合
        if (p1.isAllSatisfied() && p2.isAllSatisfied()) {
            intersectResult.transferAllSatisfied();
            return intersectResult;
        }
        // 存在无合法对象，则均为不符合
        if (p1.isNoLegalObjs() || p2.isNoLegalObjs()) {
            return intersectResult;
        }

        // 进行遍历操作原对象集合，收集合法对象
        for (Object srcObj : srcCol) {
            if (p1.isIegalObj(srcObj) && p2.isIegalObj(srcObj)) {
                intersectResult.addIllegalObj(srcObj);
            }
        }

        return intersectResult;
    }


    @Override
    public void exitOrStat(WhereStatementParser.OrStatContext ctx) {
        // 格式: stat or stat
        LegalObjPack statResult01 = legalObjStack.pop();
        LegalObjPack statResult02 = legalObjStack.pop();
        LegalObjPack unionResult = unionLegalObjPack(statResult01, statResult02);
        // 入栈并集结果
        legalObjStack.push(unionResult);
    }

    /**
     * 合并 封装的合法对象
     * @param p1 对象1
     * @param p2 对象2
     * @return
     */
    private LegalObjPack unionLegalObjPack(LegalObjPack p1, LegalObjPack p2) {
        LegalObjPack unionResult = new LegalObjPack();
        // 如果有全部符合的情况，则并集也是全部符合
        if (p1.isAllSatisfied() || p2.isAllSatisfied()) {
            unionResult.transferAllSatisfied();
            return unionResult;
        }
        // 均无合法对象
        if (p1.isNoLegalObjs() && p2.isNoLegalObjs()) {
            return unionResult;
        }
        // p1无合法对象，则直接使用p2作为并集结果
        if (p1.isNoLegalObjs() ) {
            unionResult = p2;
            return unionResult;
        }
        // p2无合法对象，则直接使用p1作为并集结果
        if (p2.isNoLegalObjs() ) {
            unionResult = p1;
            return unionResult;
        }
        // 进行遍历操作原对象集合，收集合法对象
        for (Object srcObj : srcCol) {
            if (p1.isIegalObj(srcObj) || p2.isIegalObj(srcObj)) {
                unionResult.addIllegalObj(srcObj);
            }
        }

        return unionResult;
    }

    @Override
    public void exitStringVal(WhereStatementParser.StringValContext ctx) {
        nodeStack.push(new StringValExpType(ctx.getText()));
    }

    @Override
    public void exitNumberVal(WhereStatementParser.NumberValContext ctx) {
        nodeStack.push(new NumberValExpType(ctx.getText()));
    }

    @Override
    public void exitBooleanVal(WhereStatementParser.BooleanValContext ctx) {
        nodeStack.push(new BooleanValExpType(ctx.getText()));
    }

    @Override
    public void exitNullVal(WhereStatementParser.NullValContext ctx) {
        nodeStack.push(new NullValExpType(ctx.getText()));
    }

    @Override
    public void exitFieldPlaceVal(WhereStatementParser.FieldPlaceValContext ctx) {
        nodeStack.push(new FieldPlaceValExpType(ctx.getText(), this.coreProfile));
    }

    @Override
    public void exitFunPlaceVal(WhereStatementParser.FunPlaceValContext ctx) {
        FunPlaceValExpType funPlaceValType = new FunPlaceValExpType(ctx.getText(), this.coreProfile, this.srcCol);
        // 取出函数占位符
        FunPlaceExpType funPlaceExpType = (FunPlaceExpType) nodeStack.pop();
        // 添加对应参数的表达式
        for (int i = 0; i < funPlaceExpType.getArgQuantity(); i++) {
            funPlaceValType.addArgExpTypes((ValExpType) nodeStack.pop());
        }
        // 使用栈堆方式入参，故需要进行反转，参数顺序才和表达式一致
        funPlaceValType.reverseArg();
        nodeStack.push(funPlaceValType);
    }

    @Override
    public void exitFunPlace(WhereStatementParser.FunPlaceContext ctx) {
        FunPlaceExpType funPlaceExpType = new FunPlaceExpType(ctx.getText());
        // 统计参数数量，根据逗号分隔符来统计。
        int argQuantity = 0;
        // 函数表达式格式：F{name}、F{name()}、F{name(arg1,arg2,arg3...)}
        int loopCount = 0;
        for (ParseTree child : ctx.children) {
            if (LEFT_PARENTHESIS.equals(child.getText())) {
                // 当出现左括号(后，下一个子节点不是右括号)，则说明不是空的()括号，肯定存在有参数，初始数量为1。
                if (!RIGHT_PARENTHESIS.equals(ctx.getChild(loopCount + 1).getText())) {
                    argQuantity = 1;
                }
            } else if (COMMA_SEPARATOR.equals(child.getText())) {
                // 每出现一个逗号分隔符，则参数数量+1
                argQuantity++;
            }
            loopCount++;
        }
        funPlaceExpType.setArgQuantity(argQuantity);

        nodeStack.push(funPlaceExpType);
    }

    @Override
    public void exitBinaryCond(WhereStatementParser.BinaryCondContext ctx) {
        nodeStack.push(new BinaryCondExpType(StrHelper.joinChildTextUseBlankPart(ctx)));
    }

    @Override
    public void exitOperator(WhereStatementParser.OperatorContext ctx) {
        nodeStack.push(new OperatorExpType(StrHelper.joinChildTextUseBlankPart(ctx)));
    }

    @Override
    public void exitInCond(WhereStatementParser.InCondContext ctx) {
        InCondExpType inCondExpType = new InCondExpType(StrHelper.joinChildTextUseBlankPart(ctx));
        // 统计参数数量，根据逗号分隔符来统计，初始参数从1开始。
        int paramQuantity = 1;
        for (ParseTree expType : ctx.children) {
            if (COMMA_SEPARATOR.equals(expType.getText())) {
                paramQuantity ++;
            }
        }
        inCondExpType.setParamQuantity(paramQuantity);
        nodeStack.push(inCondExpType);
    }

    @Override
    public void exitBetweenCond(WhereStatementParser.BetweenCondContext ctx) {
        nodeStack.push(new BetweenCondExpType(StrHelper.joinChildTextUseBlankPart(ctx)));
    }

    @Override
    public void exitNullCond(WhereStatementParser.NullCondContext ctx) {
        nodeStack.push(new NullCondExpType(StrHelper.joinChildTextUseBlankPart(ctx)));
    }

    @Override
    public void exitNotNullCond(WhereStatementParser.NotNullCondContext ctx) {
        nodeStack.push(new NotNullCondExpType(StrHelper.joinChildTextUseBlankPart(ctx)));
    }

    @Override
    public void exitValCond(WhereStatementParser.ValCondContext ctx) {
        nodeStack.push(new ValCondExpType(StrHelper.joinChildTextUseBlankPart(ctx)));
    }

    /**
     * 获取集合结果
     * @return 符合条件的对象集合
     */
    public List<T> getColResult() {
        checkBeforeGetResult();
        this.isAlreadFetchResult = true;
        LegalObjPack legalObjPack = legalObjStack.pop();
        List<T> result;
        if (legalObjPack.isAllSatisfied()) {
            result = new ArrayList<>(srcCol);
        } else if (legalObjPack.isNoLegalObjs()) {
            result = Collections.emptyList();
        } else {
            result = new ArrayList<>(legalObjPack.expectLegalSize());
            for (T src : srcCol) {
                if (legalObjPack.isIegalObj(src)) {
                    result.add(src);
                }
            }
        }
        return result;
    }

    /**
     * 获取布尔结果
     * @return 如果存在符合条件的对象则返回true，反之false。
     */
    public boolean getBolResult() {
        checkBeforeGetResult();
        this.isAlreadFetchResult = true;
        LegalObjPack legalObjPack = legalObjStack.pop();
        boolean result;
        if (legalObjPack.isNoLegalObjs()) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    /**
     * 获取统计结果
     * @return 符合条件的的数量
     */
    public int getCountResult() {
        checkBeforeGetResult();
        this.isAlreadFetchResult = true;
        LegalObjPack legalObjPack = legalObjStack.pop();
        int result;
        if (legalObjPack.isNoLegalObjs()) {
            result = 0;
        } else if (legalObjPack.isAllSatisfied()) {
            result = this.srcCol.size();
        } else {
            result = legalObjPack.expectLegalSize();
        }
        return result;
    }

    /**
     * 获取结果前的校验
     */
    private void checkBeforeGetResult() {
        // 不考虑需要多次获取结果的情况
        if (isAlreadFetchResult) {
            throw new OqlExpResolvedException("结果已经被取出，请勿重复调用");
        }

        int size = legalObjStack.size();
        if (size == 0) {
            throw new OqlExpResolvedException("请先执行语法树遍历");
        }

        if (size > 1) {
            throw new OqlExpResolvedException("语法解析执行异常，存在多个结果集");
        }
    }
}
