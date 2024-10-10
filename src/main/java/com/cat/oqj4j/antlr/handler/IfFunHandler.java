package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.FunHandlerContext;
import com.cat.oqj4j.support.OpeDiagnotor;

/**
 * If函数处理器，用于判断arg1参数，如果为真则返回arg2参数，反之返回arg3。
 * 例如： ${If(arg1, arg2, arg3)}。
 * @author gwj
 */
public class IfFunHandler extends AbstractFunHandler {
    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    public Object handleActually(FunHandlerContext context) {
        Object[] args = context.getArgs();
        Boolean isSatisfied = opeDiagnotor.tryDiagnosticBool(args[0]);
        if (isSatisfied == null) {
            throw new OqlExpResolvedException(args[0] + "参数无法判断布尔结果");
        }
        Object result = null;
        if (isSatisfied) {
            result = args[1];
        } else {
            result = args[2];
        }
        return result;
    }

    @Override
    protected int getRequiredArgsSize() {
        return 3;
    }

    @Override
    public String getSupportedFunName() {
        return "If";
    }
}
