package com.cat.oqj4j.support;

import com.cat.oqj4j.antlr.type.*;
import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Collection;

/**
 * antlr助手类
 * @author gwj
 */
public abstract class AntlrHelper {

    /**
     * 逗号分隔符
     */
    public final static String COMMA_SEPARATOR = ",";
    /**
     * 左括号标识符
     */
    public final static String LEFT_PARENTHESIS = "(";
    /**
     * 右括号标识符
     */
    public final static String RIGHT_PARENTHESIS = ")";

    /**
     * 是否值表达式类型
     * @param expType 表达式类型
     * @return true表示属于值表达式类型
     */
    public static boolean isValExpType(ExpType expType) {
        return expType instanceof ValExpType;
    }

    /**
     * 获取表达式的值
     * @param srcObj 源对象
     * @param valExpType 值表达式
     * @return 表达式的值
     */
    public static Object getExpVal(Object srcObj, ValExpType valExpType) {
        Object result = null;
        // 只支持常量值表达式和动态值表达式
        if (valExpType instanceof DynamicValExpType) {
            result = ((DynamicValExpType) valExpType).getVal(srcObj);
        } else if (valExpType instanceof ConstValExpType) {
            result = ((ConstValExpType<?>) valExpType).getVal();
        } else {
            throw new OqlExpResolvedException(valExpType.getExp() + "表达式类型无法识别");
        }
        return result;
    }

    /**
     * 获取表达式的值
     * @param srcObj 源对象
     * @param expType 表达式
     * @return 表达式的值
     */
    public static Object getExpVal(Object srcObj, ExpType expType) {
        if (!isValExpType(expType)) {
            throw new OqlExpResolvedException(expType.getExp() + "不是值表达式，无法获取结果值");
        }
        return getExpVal(srcObj, (ValExpType)expType);
    }

    /**
     * 生成 函数取值占位符表达式
     * @param context 上下文
     * @return 表达式
     */
    public static FunPlaceExpType generateFunPlaceExpType(ParserRuleContext context) {
        FunPlaceExpType funPlaceExpType = new FunPlaceExpType(context.getText());
        // 统计参数数量，根据逗号分隔符来统计。
        int argQuantity = 0;
        // 函数表达式格式：F{name}、F{name()}、F{name(arg1,arg2,arg3...)}
        int loopCount = 0;
        for (ParseTree child : context.children) {
            if (LEFT_PARENTHESIS.equals(child.getText())) {
                // 当出现左括号(后，下一个子节点不是右括号)，则说明不是空的()括号，肯定存在有参数，初始数量为1。
                if (!RIGHT_PARENTHESIS.equals(context.getChild(loopCount + 1).getText())) {
                    argQuantity = 1;
                }
            } else if (COMMA_SEPARATOR.equals(child.getText())) {
                // 每出现一个逗号分隔符，则参数数量+1
                argQuantity++;
            }
            loopCount++;
        }
        funPlaceExpType.setArgQuantity(argQuantity);

        return funPlaceExpType;
    }


}
