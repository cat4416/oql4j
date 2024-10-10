package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.support.FunHandlerContext;

/**
 * CastChar函数处理器，用于 转换为Character对象。
 * ps：
 *   1、如果参数为null，则返回null。
 *   2、先将对象展会为字符串，然后再转换为char。
 *   3、如果转换为字符串后长度为0，则返回null。
 *   4、如果转换为字符串后长度大于1，则报错。
 * 例如: F{CastChar(arg)}
 * @author gwj
 */
public class CastCharFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(FunHandlerContext context) {
        Character result = null;
        Object[] args = context.getArgs();
        if (args.length > 0 && args[0] != null) {
            if (args[0] instanceof Character) {
                result = (Character) args[0];
            } else {
                String str = args[0].toString();
                if (str.length() > 1) {
                    throw new IllegalArgumentException(str + "字符长度大于1，无法转为cahr类型");
                }
                if (str.length() == 1) {
                    result = new Character(str.toCharArray()[0]);
                }
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
        return "CastChar";
    }
}
