package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.antlr.type.*;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.LegalObjPack;
import com.cat.oqj4j.support.OpeDiagnotor;
import com.cat.oqj4j.support.StrHelper;

import java.util.Collection;
import java.util.Deque;

/**
 * 值表达式处理器
 * ps：即直接用当前值来判断布尔条件的真假
 * @author gwj
 */
public class ValCondHandler extends AbstractCondHandler<ValCondExpType> {
    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    protected LegalObjPack handleDynamicExpCond(ValCondExpType condExpType, DynamicValExpType nameExp,
                                                Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        for (Object srcObj : srcCol) {
            Object nameVal = nameExp.getVal(srcObj);
            Boolean isStatisfied = opeDiagnotor.tryDiagnosticBool(nameVal);
            if (isStatisfied == null) {
                throw new OqlExpResolvedException(StrHelper.fillPlaceholder("{}表达式的值为【{}】，无法判断布尔结果", nameExp.getExp(), nameVal));
            }
            if (isStatisfied) {
                legalObjPack.addIllegalObj(srcObj);
            }
        }
        return legalObjPack;
    }

    @Override
    protected LegalObjPack handleConstExpCond(ValCondExpType condExpType, ConstValExpType nameExp,
                                              Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        Object nameVal = nameExp.getVal();
        Boolean isStatisfied = opeDiagnotor.tryDiagnosticBool(nameExp.getVal());
        if (isStatisfied == null) {
            throw new OqlExpResolvedException(StrHelper.fillPlaceholder("{}表达式的值为【{}】，无法判断布尔结果", nameExp.getExp(), nameVal));
        }
        // 常量表达式判断，如果存在符合条件的，则全部对象都符合
        if (isStatisfied) {
            legalObjPack.transferAllSatisfied();
        }
        return legalObjPack;
    }
}
