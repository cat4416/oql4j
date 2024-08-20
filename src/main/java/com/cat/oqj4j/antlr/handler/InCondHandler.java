package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.antlr.type.ConstValExpType;
import com.cat.oqj4j.antlr.type.DynamicValExpType;
import com.cat.oqj4j.antlr.type.ExpType;
import com.cat.oqj4j.antlr.type.InCondExpType;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.LegalObjPack;
import com.cat.oqj4j.support.OpeDiagnotor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

/**
 * IN条件处理器
 * @author gwj
 */
@ThreadSafe
public class InCondHandler extends AbstractCondHandler<InCondExpType> {
    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    protected LegalObjPack handleDynamicExpCond(InCondExpType condExpType, DynamicValExpType nameExp,
                                                Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        // 取出表达式值
        int paramQuantity = condExpType.getParamQuantity();
        List<ConstValExpType> constExpValTypes = new ArrayList<>();
        List<DynamicValExpType> dynamicValExpTypes = new ArrayList<>();
        fetchParamAndGroup(paramQuantity, nodeStack, constExpValTypes, dynamicValExpTypes);

        for (Object srcObj : srcCol) {
            Object nameVal = nameExp.getVal(srcObj);
            boolean isStatisfied = false;
            // 常量值判断
            for (ConstValExpType constExpValType : constExpValTypes) {
                if (opeDiagnotor.diagnoseEQ(nameVal, constExpValType.getVal())) {
                    isStatisfied = true;
                    break;
                }
            }
            // 常量值不符合条件，则进一步查动态值
            if (!isStatisfied) {
                for (DynamicValExpType dynamicValExpType : dynamicValExpTypes) {
                    if (opeDiagnotor.diagnoseEQ(nameVal, dynamicValExpType.getVal(srcObj))) {
                        isStatisfied = true;
                        break;
                    }
                }
            }

            if (isStatisfied) {
                legalObjPack.addIllegalObj(srcObj);
            }
        }

        return legalObjPack;
    }

    @Override
    protected LegalObjPack handleConstExpCond(InCondExpType condExpType, ConstValExpType nameExp,
                                              Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        // 取出表达式值
        int paramQuantity = condExpType.getParamQuantity();
        List<ConstValExpType> constExpValTypes = new ArrayList<>();
        List<DynamicValExpType> dynamicValExpTypes = new ArrayList<>();
        fetchParamAndGroup(paramQuantity, nodeStack, constExpValTypes, dynamicValExpTypes);

        Object nameVal = nameExp.getVal();
        // 常量值判断
        for (ConstValExpType constExpValType : constExpValTypes) {
            // 常量表达式判断，如果存在符合条件的，则全部对象都符合
            if (opeDiagnotor.diagnoseEQ(nameVal, constExpValType.getVal())) {
                legalObjPack.transferAllSatisfied();
                break;
            }
        }

        // 如果未全部符合，则进一步判断动态值
        if (!legalObjPack.isAllSatisfied()) {
            for (DynamicValExpType dynamicValExpType : dynamicValExpTypes) {
                for (Object srcObj : srcCol) {
                    if (opeDiagnotor.diagnoseEQ(nameVal, dynamicValExpType.getVal(srcObj))) {
                        legalObjPack.addIllegalObj(srcObj);
                    }
                }
            }
        }

        return legalObjPack;
    }

    /**
     * 取出参数并进行分组
     * @param paramQuantity 参数数量
     * @param nodeStack 节点栈
     * @param constExpValTypes 常量值参数。对应的分组参数将增加到此集合。
     * @param dynamicValExpTypes 动态值参数。对应的分组参数将增加到此集合。
     */
    private void fetchParamAndGroup(int paramQuantity, Deque<ExpType> nodeStack,
                                    List<ConstValExpType> constExpValTypes,
                                    List<DynamicValExpType> dynamicValExpTypes) {
        for (int i = 0; i < paramQuantity; i++) {
            ExpType expValTyp = nodeStack.pop();
            if (expValTyp instanceof ConstValExpType) {
                constExpValTypes.add((ConstValExpType) expValTyp);
            } else if (expValTyp instanceof DynamicValExpType) {
                dynamicValExpTypes.add((DynamicValExpType) expValTyp);
            } else {
                throw new OqlExpResolvedException("无法识别的" + expValTyp.getExp() + "值类型");
            }
        }
    }
}
