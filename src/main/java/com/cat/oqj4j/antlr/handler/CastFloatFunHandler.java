package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.support.FunHandlerContext;

/**
 * CastFloat函数处理器，用于 转换为Float对象。
 * ps：如果参数为null，则返回null。
 * 例如: F{CastFloat(arg)}
 * @author gwj
 */
public class CastFloatFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(FunHandlerContext context) {
        Float result = null;
        Object[] args = context.getArgs();
        if (args.length > 0 && args[0] != null) {
            if (args[0] instanceof Float) {
                result = (Float) args[0];
            } else {
                result = new Float(args[0].toString());
            }
        }
        return result;
    }

    @Override
    protected int getMaxArgsSize() {
        return 1;
    }

    @Override
    public String getSupportedFunName() {
        return "CastFloat";
    }
}
