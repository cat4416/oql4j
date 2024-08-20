package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.antlr.type.ConstValExpType;
import com.cat.oqj4j.antlr.type.DynamicValExpType;
import com.cat.oqj4j.antlr.type.ExpType;
import com.cat.oqj4j.antlr.type.NullCondExpType;
import com.cat.oqj4j.support.LegalObjPack;
import com.cat.oqj4j.support.OpeDiagnotor;

import java.util.Collection;
import java.util.Deque;

/**
 * IS NULL条件表达式处理器
 * @author gwj
 */
public class NullCondHandler extends AbstractCondHandler<NullCondExpType> {
    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    protected LegalObjPack handleDynamicExpCond(NullCondExpType condExpType, DynamicValExpType nameExp,
                                                Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        for (Object srcObj : srcCol) {
            Object nameVal = nameExp.getVal(srcObj);
            if (opeDiagnotor.diagnoseEQ(nameVal, null)) {
                legalObjPack.addIllegalObj(srcObj);
            }
        }
        return legalObjPack;
    }

    @Override
    protected LegalObjPack handleConstExpCond(NullCondExpType condExpType, ConstValExpType nameExp,
                                              Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        Object nameVal = nameExp.getVal();
        // 常量表达式判断，如果存在符合条件的，则全部对象都符合
        if (opeDiagnotor.diagnoseEQ(nameVal, null)) {
            legalObjPack.transferAllSatisfied();
        }
        return legalObjPack;
    }
}
