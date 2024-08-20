package com.cat.oqj4j.antlr.handler;

import java.util.Collection;

/**
 * CastDouble函数处理器，用于 转换为Double对象。
 * ps：如果参数为null，则返回null。
 * 例如: F{CastDouble(arg)}
 * @author gwj
 */
public class CastDoubleFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(Collection<?> srcCol, Object curObj, Object... args) {
        Double result = null;
        if (args.length > 0 && args[0] != null) {
            if (args[0] instanceof Double) {
                result = (Double) args[0];
            } else {
                result = new Double(args[0].toString());
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
        return "CastDouble";
    }
}
