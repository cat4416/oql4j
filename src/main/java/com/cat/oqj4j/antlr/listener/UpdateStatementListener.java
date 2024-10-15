package com.cat.oqj4j.antlr.listener;

import com.cat.oqj4j.antlr.gen.SelectStatementParser;
import com.cat.oqj4j.antlr.gen.UpdateStatementBaseListener;
import com.cat.oqj4j.antlr.gen.UpdateStatementParser;
import com.cat.oqj4j.antlr.type.*;
import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.BeanHandlingException;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.AntlrHelper;
import com.cat.oqj4j.support.BeanHandler;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

/**
 * update表达式监听器
 * @author gwj
 */
public class UpdateStatementListener extends UpdateStatementBaseListener {
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
    private final Collection<?> srcCol;

    /**
     * 是否已执行更新
     */
    private boolean isAlreadUpdate;

    /**
     * 构造对象
     * @param coreProfile 核心剖面
     * @param srcCol 原对象
     */
    public UpdateStatementListener(OqlCoreProfile coreProfile, Collection<?> srcCol) {
        if (srcCol == null) {
            throw new IllegalArgumentException("操作集合不能为空");
        }
        this.coreProfile = coreProfile;
        this.srcCol = srcCol;
    }

    @Override
    public void enterParse(UpdateStatementParser.ParseContext ctx) {
        // 防止重复执行更新
        if (isAlreadUpdate) {
            throw new OqlExpResolvedException("已执行过更新处理，请勿重复调用");
        }
        this.isAlreadUpdate = true;
    }

    @Override
    public void exitBaseAssign(UpdateStatementParser.BaseAssignContext ctx) {
        // 格式： 字段 = 更新值，其中只对字段和更新值做了节点入栈，故只需要取两个栈元素
        ValExpType updateVal = (ValExpType) nodeStack.pop();
        UpdateFiledExpType updateField = (UpdateFiledExpType) nodeStack.pop();
        BeanHandler beanHandler = coreProfile.getBeanHandler();
        for (Object srcObj : srcCol) {
            // 取出表达式的值
            Object objVal = AntlrHelper.getExpVal(srcObj, updateVal);
            // 赋值。采用宽松模式。
            try {
                beanHandler.setFieldVal(srcObj, updateField.getExp(), objVal);
            } catch (BeanHandlingException e) {
                throw new OqlExpResolvedException(updateField.getExp() + "赋值异常", e);
            }
        }
    }

    @Override
    public void exitUpdateField(UpdateStatementParser.UpdateFieldContext ctx) {
        nodeStack.push(new UpdateFiledExpType(FieldPlaceValExpType.getFieldName(ctx.getText())));
    }

    @Override
    public void exitStringVal(UpdateStatementParser.StringValContext ctx) {
        nodeStack.push(new StringValExpType(ctx.getText()));
    }

    @Override
    public void exitNumberVal(UpdateStatementParser.NumberValContext ctx) {
        nodeStack.push(new NumberValExpType(ctx.getText()));
    }

    @Override
    public void exitBooleanVal(UpdateStatementParser.BooleanValContext ctx) {
        nodeStack.push(new BooleanValExpType(ctx.getText()));
    }

    @Override
    public void exitNullVal(UpdateStatementParser.NullValContext ctx) {
        nodeStack.push(new NullValExpType(ctx.getText()));
    }

    @Override
    public void exitFieldPlaceVal(UpdateStatementParser.FieldPlaceValContext ctx) {
        nodeStack.push(new FieldPlaceValExpType(ctx.getText(), this.coreProfile));
    }

    @Override
    public void exitFunPlaceVal(UpdateStatementParser.FunPlaceValContext ctx) {
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
    public void exitFunPlace(UpdateStatementParser.FunPlaceContext ctx) {
        FunPlaceExpType funPlaceExpType = AntlrHelper.generateFunPlaceExpType(ctx);
        nodeStack.push(funPlaceExpType);
    }

    @Override
    public void exitMethodPlaceVal(UpdateStatementParser.MethodPlaceValContext ctx) {
        MethodPlaceValExpType methodPlaceValType = new MethodPlaceValExpType(ctx.getText(), this.coreProfile, this.srcCol);
        // 取出函数占位符
        MethodPlaceExpType methodPlaceExpType = (MethodPlaceExpType) nodeStack.pop();
        // 添加对应参数的表达式
        for (int i = 0; i < methodPlaceExpType.getArgQuantity(); i++) {
            methodPlaceValType.addArgExpTypes((ValExpType) nodeStack.pop());
        }
        // 使用栈堆方式入参，故需要进行反转，参数顺序才和表达式一致
        methodPlaceValType.reverseArg();
        nodeStack.push(methodPlaceValType);
    }

    @Override
    public void exitMethodPlace(UpdateStatementParser.MethodPlaceContext ctx) {
        MethodPlaceExpType methodPlaceExpType = AntlrHelper.generateMethodPlaceExpType(ctx);
        nodeStack.push(methodPlaceExpType);
    }

    @Override
    public void exitListVal(UpdateStatementParser.ListValContext ctx) {
        // 格式为： [e1, e2, e3...]
        ListValExpType listValExpType = new ListValExpType(ctx.getText(), this.coreProfile, this.srcCol);
        int bracketsArgQuantity = AntlrHelper.getBracketsArgQuantity(ctx);
        // 添加对应元素的表达式
        for (int i = 0; i < bracketsArgQuantity; i++) {
            listValExpType.addElementExpTypes((ValExpType) nodeStack.pop());
        }
        // 使用栈堆方式入参，故需要进行反转，元素顺序才和表达式一致
        listValExpType.reverseElement();
        nodeStack.push(listValExpType);
    }

    /**
     * 获取更新的记录数
     * @return 记录数
     */
    public int getUpdateRecord() {
        if (!isAlreadUpdate) {
            throw new OqlExpResolvedException("请先执行语法树遍历");
        }
        return srcCol.size();
    }

}
