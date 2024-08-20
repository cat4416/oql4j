package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.antlr.type.*;
import com.cat.oqj4j.support.LegalObjPack;
import com.cat.oqj4j.support.OpeDiagnotor;

import java.util.Collection;
import java.util.Deque;

/**
 * IS NOT NULL条件表达式处理器
 * @author gwj
 */
public class NotNullCondHandler extends AbstractCondHandler<NotNullCondExpType> {
    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    protected LegalObjPack handleDynamicExpCond(NotNullCondExpType condExpType, DynamicValExpType nameExp,
                                                Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        for (Object srcObj : srcCol) {
            Object nameVal = nameExp.getVal(srcObj);
            if (opeDiagnotor.diagnoseNEQ(nameVal, null)) {
                legalObjPack.addIllegalObj(srcObj);
            }
        }
        return legalObjPack;
    }

    @Override
    protected LegalObjPack handleConstExpCond(NotNullCondExpType condExpType, ConstValExpType nameExp,
                                              Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        Object nameVal = nameExp.getVal();
        // 常量表达式判断，如果存在符合条件的，则全部对象都符合
        if (opeDiagnotor.diagnoseNEQ(nameVal, null)) {
            legalObjPack.transferAllSatisfied();
        }
        return legalObjPack;
    }
}
