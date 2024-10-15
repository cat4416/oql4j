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
     * 左圆括号标识符
     */
    public final static String LEFT_PARENTHESIS = "(";
    /**
     * 右圆括号标识符
     */
    public final static String RIGHT_PARENTHESIS = ")";

    /**
     * 左方括号标识符
     */
    public final static String LEFT_BRACKETS = "[";
    /**
     * 右方括号标识符
     */
    public final static String RIGHT_BRACKETS = "]";

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
        // 函数表达式格式：F{name}、F{name()}、F{name(arg1,arg2,arg3...)}
        FunPlaceExpType funPlaceExpType = new FunPlaceExpType(context.getText());
        // 统计参数数量，根据逗号分隔符来统计。
        int argQuantity = getParenthesisArgQuantity(context);
        funPlaceExpType.setArgQuantity(argQuantity);
        return funPlaceExpType;
    }


    /**
     * 生成 对象方法取值占位符表达式
     * @param context 上下文
     * @return 表达式
     */
    public static MethodPlaceExpType generateMethodPlaceExpType(ParserRuleContext context) {
        // 方法表达式格式：M{name}、M{name()}、M{name(arg1,arg2,arg3...)}
        MethodPlaceExpType methodPlaceExpType = new MethodPlaceExpType(context.getText());
        // 统计参数数量，根据逗号分隔符来统计。
        int argQuantity = getParenthesisArgQuantity(context);
        methodPlaceExpType.setArgQuantity(argQuantity);
        return methodPlaceExpType;
    }



    /**
     * 获取 圆括号 内的参数数量
     * ps：格式为 xxx(arg1,arg2,arg3...) 的圆括号参数
     * @param context 上下文
     * @return 参数数量
     */
    public static int getParenthesisArgQuantity(ParserRuleContext context) {
        return getArgQuantity(context, LEFT_PARENTHESIS, RIGHT_PARENTHESIS);
    }

    /**
     * 获取 方括号 内的参数数量
     * ps：格式为 xxx[arg1,arg2,arg3...] 的方括号参数
     * @param context 上下文
     * @return 参数数量
     */
    public static int getBracketsArgQuantity(ParserRuleContext context) {
        return getArgQuantity(context, LEFT_BRACKETS, RIGHT_BRACKETS);
    }

    /**
     * 获取 关键字符 内的参数数量
     * ps：格式为 xxx leftKeyword arg1,arg2,arg3... rightKeyword
     * @param context 上下文
     * @param leftKeyword 左关键字符
     * @param rightKeyword 右关键字符
     * @return 参数数量
     */
    private static int getArgQuantity(ParserRuleContext context, String leftKeyword, String rightKeyword) {
        // 统计参数数量，根据逗号分隔符来统计。
        int argQuantity = 0;
        // 取出 格式为 xxx leftKeyword arg1,arg2,arg3... rightKeyword 的arg参数数量
        int loopCount = 0;
        for (ParseTree child : context.children) {
            if (leftKeyword.equals(child.getText())) {
                // 当出现左括号(后，下一个子节点不是右括号)，则说明不是空的()括号，肯定存在有参数，初始数量为1。
                if (!rightKeyword.equals(context.getChild(loopCount + 1).getText())) {
                    argQuantity = 1;
                }
            } else if (COMMA_SEPARATOR.equals(child.getText())) {
                // 每出现一个逗号分隔符，则参数数量+1
                argQuantity++;
            }
            loopCount++;
        }
        return argQuantity;
    }


}
