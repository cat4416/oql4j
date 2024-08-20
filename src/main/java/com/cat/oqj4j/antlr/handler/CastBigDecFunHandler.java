package com.cat.oqj4j.antlr.handler;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * CastBigDec函数处理器，用于 转换为BigDecimal对象。
 * ps：如果参数为null，则返回null。
 * 例如: F{CastBigDec(arg)}
 * @author gwj
 */
public class CastBigDecFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(Collection<?> srcCol, Object curObj, Object... args) {
        BigDecimal result = null;
        if (args.length > 0 && args[0] != null) {
            if (args[0] instanceof BigDecimal) {
                result = (BigDecimal) args[0];
            } else {
                result = new BigDecimal(args[0].toString());
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
        return "CastBigDec";
    }
}
