package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.support.OpeDiagnotor;

import java.util.Collection;

/**
 * CastBool函数处理器，用于 转换为Boolean对象。
 * ps：
 *   1、如果参数为null，则返回null。
 *   2、如果参数为字符串或数字时，0和false字符串都属于假，1和true字符串则属于真(false和true字符串不区分大小写)。
 * 例如: F{CastBool(arg)}
 * @author gwj
 */
public class CastBoolFunHandler extends AbstractFunHandler {

    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    public Object handleActually(Collection<?> srcCol, Object curObj, Object... args) {
        Boolean result = null;
        if (args.length > 0 && args[0] != null) {
            result = opeDiagnotor.tryDiagnosticBool(args[0]);
        }
        return result;
    }

    @Override
    protected int getMaxArgsSize() {
        return 1;
    }

    @Override
    public String getSupportedFunName() {
        return "CastBool";
    }
}
