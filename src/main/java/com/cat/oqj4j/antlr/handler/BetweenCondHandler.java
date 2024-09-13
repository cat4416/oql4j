package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.antlr.type.BetweenCondExpType;
import com.cat.oqj4j.antlr.type.ConstValExpType;
import com.cat.oqj4j.antlr.type.DynamicValExpType;
import com.cat.oqj4j.antlr.type.ExpType;
import com.cat.oqj4j.support.AntlrHelper;
import com.cat.oqj4j.support.LegalObjPack;
import com.cat.oqj4j.support.OpeDiagnotor;

import java.util.Collection;
import java.util.Deque;

/**
 * BETWEEN条件处理器
 * 格式：name between min and max
 * @author gwj
 */
public class BetweenCondHandler extends AbstractCondHandler<BetweenCondExpType>{
    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    protected LegalObjPack handleDynamicExpCond(BetweenCondExpType condExpType, DynamicValExpType nameExp,
                                                Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        ExpType maxExp = nodeStack.pop();
        ExpType minExp = nodeStack.pop();
        for (Object srcObj : srcCol) {
            Object nameVal = nameExp.getVal(srcObj);

            Object maxVal = AntlrHelper.getExpVal(srcObj, maxExp);
            // 是否在最大值界限内
            boolean isMaxBound = opeDiagnotor.diagnoseLE(nameVal, maxVal);
            // 符合最大值的情况下，再进一步判断最小值
            if (isMaxBound) {
                Object minVal = AntlrHelper.getExpVal(srcObj, minExp);
                // 是否达到最小值门槛
                boolean isMinThreshold = opeDiagnotor.diagnoseGE(nameVal, minVal);
                if (isMinThreshold) {
                    legalObjPack.addIllegalObj(srcObj);
                }
            }
        }
        return legalObjPack;
    }

    @Override
    protected LegalObjPack handleConstExpCond(BetweenCondExpType condExpType, ConstValExpType nameExp,
                                              Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        ExpType maxExp = nodeStack.pop();
        ExpType minExp = nodeStack.pop();
        Object nameVal = nameExp.getVal();

        // 判断最大值与最小值是否存在动态变量
        if (maxExp instanceof DynamicValExpType || minExp instanceof DynamicValExpType) {
            for (Object srcObj : srcCol) {
                Object maxVal = AntlrHelper.getExpVal(srcObj, maxExp);
                // 是否在最大值界限内
                boolean isMaxBound = opeDiagnotor.diagnoseLE(nameVal, maxVal);
                // 符合最大值的情况下，再进一步判断最小值
                if (isMaxBound) {
                    Object minVal = AntlrHelper.getExpVal(srcObj, minExp);
                    // 是否达到最小值门槛
                    boolean isMinThreshold = opeDiagnotor.diagnoseGE(nameVal, minVal);
                    if (isMinThreshold) {
                        legalObjPack.addIllegalObj(srcObj);
                    }
                }
            }
        } else {
            // 全部都是常量，直接一次性比较
            Object maxVal = ((ConstValExpType<?>) maxExp).getVal();
            Object minVal = ((ConstValExpType<?>) minExp).getVal();
            // 是否在最大值界限内
            boolean isMaxBound = opeDiagnotor.diagnoseLE(nameVal, maxVal);
            // 符合最大值的情况下，再进一步判断最小值
            if (isMaxBound) {
                // 是否达到最小值门槛
                boolean isMinThreshold = opeDiagnotor.diagnoseGE(nameVal, minVal);
                //常量值符合条件，则全部对象都符合
                if (isMinThreshold) {
                    legalObjPack.transferAllSatisfied();
                }
            }
        }
        return legalObjPack;
    }
}
