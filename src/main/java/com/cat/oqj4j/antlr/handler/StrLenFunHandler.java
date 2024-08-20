package com.cat.oqj4j.antlr.handler;

import java.util.Collection;

/**
 * StrLen函数处理器，用于 统计字符串长度。
 * ps：将当前参数转换为字符串，并统计字符串长度。如果参数为null，则返回长度为0。
 * 例如: F{StrLen(arg)}
 * @author gwj
 */
public class StrLenFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(Collection<?> srcCol, Object curObj, Object... args) {
        // 如果参数为null，则长度为0。
        int len = 0;
        if (args.length > 0 && args[0] != null) {
            len = args[0].toString().length();
        }
        return len;
    }

    @Override
    protected int getMaxArgsSize() {
        return 1;
    }

    @Override
    public String getSupportedFunName() {
        return "StrLen";
    }
}
