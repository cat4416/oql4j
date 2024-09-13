package com.cat.oqj4j.support;

import com.cat.oqj4j.antlr.type.ConstValExpType;
import com.cat.oqj4j.antlr.type.DynamicValExpType;
import com.cat.oqj4j.antlr.type.ExpType;
import com.cat.oqj4j.antlr.type.ValExpType;
import com.cat.oqj4j.exception.OqlExpResolvedException;

/**
 * antlr助手类
 * @author gwj
 */
public abstract class AntlrHelper {
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


}
