package com.cat.oqj4j.antlr.type;

import com.cat.oqj4j.antlr.handler.FunHandler;
import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.AntlrHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 函数取值占位符的值类型表达式
 *
 * @author gwj
 */
public class FunPlaceValExpType implements DynamicValExpType {
    /**
     * 函数名称
     */
    private String funName;
    /**
     * 表达式
     */
    private String exp;
    /**
     * 核心剖面
     */
    private OqlCoreProfile oqlCore;

    /**
     * 操作原对象集合
     */
    private Collection<?> srcCol;
    /**
     * 函数括号里包含的参数表达式类型集合。
     * ps：funName(10,20,${city}) 则说明有3个参数
     */
    private List<ValExpType> argExpTypes;

    /**
     * 构造对象
     * @param exp 表达式
     * @param oqlCore 核心剖面
     * @param srcCol 原对象集合
     */
    public FunPlaceValExpType(String exp, OqlCoreProfile oqlCore, Collection<?> srcCol) {
        this.exp = exp;
        this.srcCol = srcCol;
        this.oqlCore = oqlCore;
        this.funName = getFunName(exp);
    }

    /**
     * 增加参数的表达性类型
     * @param expType 表达式类型
     */
    public void addArgExpTypes(ValExpType expType) {
        if (argExpTypes == null) {
            argExpTypes = new ArrayList<>();
        }
        argExpTypes.add(expType);
    }

    /**
     * 反转参数
     */
    public void reverseArg() {
        if (argExpTypes != null && argExpTypes.size() > 1) {
            Collections.reverse(argExpTypes);
        }
    }



    @Override
    public String getExp() {
        return this.exp;
    }


    @Override
    public Object getVal(Object srcObj) {
        FunHandler funHandler = oqlCore.fetchFunHandler(this.funName);
        if (funHandler == null) {
            throw new OqlExpResolvedException(this.funName + " 函数无对应处理器");
        }
        try {
            Object[] args = null;
            if (argExpTypes != null && !argExpTypes.isEmpty()) {
                args = new Object[argExpTypes.size()];
                for (int i = 0; i < argExpTypes.size(); i++) {
                    ValExpType argExpType = argExpTypes.get(i);
                    Object val = AntlrHelper.getExpVal(srcObj, argExpType);
                    args[i] = val;
                }
            }
            return funHandler.handleFun(this.srcCol, srcObj, args);
        } catch(OqlExpResolvedException e) {
            throw e;
        } catch(Exception e) {
            throw new OqlExpResolvedException(this.exp + "表达式处理失败", e);
        }
    }

    /**
     * 获取函数名称
     * @param expStr 表达式字符串
     * @return 字段名称
     */
    public static String getFunName(String expStr) {
        // 从表达式中取出函数名称，函数表达式格式：F{name}、F{name()}、F{name(arg1,arg2,arg3...)}
        char[] expChars = expStr.toCharArray();
        int offset = 0, count = 0;
        for (int idx = 0; idx < expChars.length; idx++) {
            if (expChars[idx] == '{') {
                // 当前字符{的下一个字符则为函数名称开始索引
                offset = idx + 1;
            } else if (expChars[idx] == '(' || expChars[idx] == '}') {
                // 当前字符(或}的前一个字符则为函数名称结束索引
                count = idx - offset;
                break;
            }
        }

        return new String(expChars, offset, count);
    }
}
