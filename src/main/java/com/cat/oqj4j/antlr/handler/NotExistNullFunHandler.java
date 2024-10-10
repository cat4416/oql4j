package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.support.FunHandlerContext;

/**
 * NotExistNull函数处理器，用于判断全部参数都不为null。
 * ps：如果无任何参数，则返回true。
 * 例如: ${NotExistNull(arg1, arg2, arg3 ...)}。
 * @author gwj
 */
public class NotExistNullFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(FunHandlerContext context) {
        Object[] args = context.getArgs();
        boolean result = true;
        for (Object arg : args) {
            if (arg == null) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public String getSupportedFunName() {
        return "NotExistNull";
    }
}
