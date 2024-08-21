package com.cat.oqj4j.antlr.handler;

import java.util.Collection;

/**
 * ClassSimpleName函数处理器，用于 获取参数的Class字节码对象的简短名称。
 * ps：如果参数为null，则返回字符串"null"。
 * 例如: F{StrLen(arg)}
 * @author gwj
 */
public class ClassSimpleNameFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(Collection<?> srcCol, Object curObj, Object... args) {
        if (args[0] == null) {
            return "null";
        }
        return args[0].getClass().getSimpleName();
    }

    @Override
    protected int getRequiredArgsSize() {
        return 1;
    }

    @Override
    public String getSupportedFunName() {
        return "ClassSimpleName";
    }
}
