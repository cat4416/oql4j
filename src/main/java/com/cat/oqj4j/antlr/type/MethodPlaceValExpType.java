package com.cat.oqj4j.antlr.type;

import com.cat.oqj4j.antlr.handler.FunHandler;
import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.BeanHandlingException;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.AntlrHelper;
import com.cat.oqj4j.support.BeanHandler;
import com.cat.oqj4j.support.FunHandlerContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 对象方法取值占位符的值类型表达式。
 * ps：注意MethodPlaceValExpType与MethodPlaceExpType 的区别，
 *     MethodPlaceExpType是对象取值占位符表达式，而MethodPlaceValExpType是作为值类型被引用，可以取得值结果。
 *     MethodPlaceExpType是基础类型(用于辅助取参)，MethodPlaceValExpType是具体使用。
 *
 * @author gwj
 */
public class MethodPlaceValExpType implements DynamicValExpType {
    /**
     * 方法名称
     */
    private String methodName;
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
     * 方法括号里包含的参数值表达式类型集合。
     * ps：methodName(10,20,${city}) 则说明有3个参数
     */
    private List<ValExpType> argExpTypes;

    /**
     * 构造对象
     * @param exp 表达式
     * @param oqlCore 核心剖面
     * @param srcCol 原对象集合
     */
    public MethodPlaceValExpType(String exp, OqlCoreProfile oqlCore, Collection<?> srcCol) {
        this.exp = exp;
        this.srcCol = srcCol;
        this.oqlCore = oqlCore;
        this.methodName = getMethodName(exp);
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
        try {
            Object[] args = null;
            Class[] methodParamTypes = null;
            if (argExpTypes != null && !argExpTypes.isEmpty()) {
                args = new Object[argExpTypes.size()];
                methodParamTypes = new Class[args.length];
                for (int i = 0; i < argExpTypes.size(); i++) {
                    ValExpType argExpType = argExpTypes.get(i);
                    Object val = AntlrHelper.getExpVal(srcObj, argExpType);
                    args[i] = val;
                    methodParamTypes[i] = val.getClass();
                }
            }

            Class srcObjClass = srcObj.getClass();
            Method targetMethod = null;
            try {
                targetMethod = srcObjClass.getMethod(methodName, methodParamTypes);
            } catch(NoSuchMethodException noMethodEx) {
                // 如果是无参方法获取失败，则直接抛出异常
                if (args == null) {
                    throw noMethodEx;
                }
                // 对于有参的方法，尝试做值类型转换
                Method[] methods = srcObjClass.getMethods();
                BeanHandler beanHandler = oqlCore.getBeanHandler();
                methodFor: for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        Class[] parameterTypes = method.getParameterTypes();
                        // 参数个数不同，直接跳过此方法
                        if (parameterTypes.length != args.length) {
                            continue;
                        }
                        Object[] targetArgs = new Object[args.length];
                        try {
                            for (int i = 0; i < parameterTypes.length; i++) {
                                targetArgs[i] = beanHandler.convertType(parameterTypes[i], args[i]);
                            }
                        } catch(BeanHandlingException beanHandEx) {
                            // 转换异常，直接跳过此方法，尝试下一个方法
                            continue methodFor;
                        }
                        // 参数转换成功，则取此方法作为目标执行方法
                        targetMethod = method;
                        args = targetArgs;
                    }
                }
                // 无法找到合适的目标方法，直接抛出异常
                if (targetMethod == null) {
                    throw noMethodEx;
                }
            }

            return targetMethod.invoke(srcObj, args);
        } catch(Exception e) {
            throw new OqlExpResolvedException(this.exp + "表达式处理失败", e);
        }
    }

    /**
     * 获取方法名称
     * @param expStr 表达式字符串
     * @return 字段名称
     */
    public static String getMethodName(String expStr) {
        // 从表达式中取出方法名称，方法表达式格式：M{name}、M{name()}、M{name(arg1,arg2,arg3...)}
        char[] expChars = expStr.toCharArray();
        int offset = 0, count = 0;
        for (int idx = 0; idx < expChars.length; idx++) {
            if (expChars[idx] == '{') {
                // 当前字符{的下一个字符则为方法名称开始索引
                offset = idx + 1;
            } else if (expChars[idx] == '(' || expChars[idx] == '}') {
                // 当前字符(或}的前一个字符则为方法名称结束索引
                count = idx - offset;
                break;
            }
        }

        return new String(expChars, offset, count);
    }
}
