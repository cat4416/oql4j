package com.cat.oqj4j.antlr.handler;

import java.util.Collection;

/**
 * CastStr函数处理器，用于 转换为字符串。
 * ps：如果参数为null，则返回null。
 * 例如: F{CastStr(arg)}
 * @author gwj
 */
public class CastStrFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(Collection<?> srcCol, Object curObj, Object... args) {
        String result = null;
        if (args.length > 0 && args[0] != null) {
            result = args[0].toString();
        }
        return result;
    }

    @Override
    protected int getMaxArgsSize() {
        return 1;
    }

    @Override
    public String getSupportedFunName() {
        return "CastStr";
    }
}
