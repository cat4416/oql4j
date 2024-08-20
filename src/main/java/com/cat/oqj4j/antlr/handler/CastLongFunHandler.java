package com.cat.oqj4j.antlr.handler;

import java.util.Collection;

/**
 * CastLong函数处理器，用于 转换为Long对象。
 * ps：如果参数为null，则返回null。
 * 例如: F{CastLong(arg)}
 * @author gwj
 */
public class CastLongFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(Collection<?> srcCol, Object curObj, Object... args) {
        Long result = null;
        if (args.length > 0 && args[0] != null) {
            if (args[0] instanceof Long) {
                result = (Long) args[0];
            } else {
                result = new Long(args[0].toString());
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
        return "CastLong";
    }
}
