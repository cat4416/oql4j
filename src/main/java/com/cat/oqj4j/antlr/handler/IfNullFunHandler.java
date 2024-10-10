package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.support.FunHandlerContext;

/**
 * IfNull函数处理器，用于判断如果arg1不为null，则返回arg1参数，否则返回arg2参数。
 * 例如: ${IfNull(arg1, arg2)}。
 * @author gwj
 */
public class IfNullFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(FunHandlerContext context) {
        Object[] args = context.getArgs();
        Object result = null;
        if (args[0] != null) {
            result = args[0];
        } else {
            result = args[1];
        }
        return result;
    }

    @Override
    protected int getRequiredArgsSize() {
        return 2;
    }

    @Override
    public String getSupportedFunName() {
        return "IfNull";
    }
}
