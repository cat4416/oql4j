package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.antlr.type.*;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.AntlrHelper;
import com.cat.oqj4j.support.LegalObjPack;
import com.cat.oqj4j.support.OpeDiagnotor;
import com.cat.oqj4j.support.OperatorEnum;

import java.util.Collection;
import java.util.Deque;

/**
 * 二元表达式处理器
 * 格式: left binaryCond right
 * @author gwj
 */
public class BinaryCondHandler extends AbstractCondHandler<BinaryCondExpType> {
    /**
     * 操作符诊断器
     */
    private final OpeDiagnotor opeDiagnotor = OpeDiagnotor.getInstance();

    @Override
    protected LegalObjPack handleDynamicExpCond(BinaryCondExpType condExpType, DynamicValExpType leftExp,
                                                Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        ExpType rightExp = nodeStack.pop();
        ExpType operator = nodeStack.pop();
        OperatorEnum operatorEnum = OperatorEnum.resolveOpeFlag(operator.getExp());
        for (Object srcObj : srcCol) {
            Object leftVal = leftExp.getVal(srcObj);
            Object rightVal = AntlrHelper.getExpVal(srcObj, rightExp);

            boolean isStatisfied = opeDiagnotor.diagnose(leftVal, rightVal, operatorEnum);
            if (isStatisfied) {
                legalObjPack.addIllegalObj(srcObj);
            }
        }
        return legalObjPack;
    }

    @Override
    protected LegalObjPack handleConstExpCond(BinaryCondExpType condExpType, ConstValExpType leftExp,
                                              Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        LegalObjPack legalObjPack = new LegalObjPack();
        ExpType rightExp = nodeStack.pop();
        ExpType operator = nodeStack.pop();
        OperatorEnum operatorEnum = OperatorEnum.resolveOpeFlag(operator.getExp());
        Object leftVal = leftExp.getVal();

        if (rightExp instanceof DynamicValExpType) {
            for (Object srcObj : srcCol) {
                Object rightVal = ((DynamicValExpType) rightExp).getVal(srcObj);
                boolean isStatisfied = opeDiagnotor.diagnose(leftVal, rightVal, operatorEnum);
                if (isStatisfied) {
                    legalObjPack.addIllegalObj(srcObj);
                }
            }
        } else if (rightExp instanceof ConstValExpType) {
            Object rightVal = ((ConstValExpType<?>) rightExp).getVal();
            boolean isStatisfied = opeDiagnotor.diagnose(leftVal, rightVal, operatorEnum);
            // 常量表达式判断，如果存在符合条件的，则全部对象都符合
            if (isStatisfied) {
                legalObjPack.transferAllSatisfied();
            }
        } else {
            throw new OqlExpResolvedException(rightExp.getExp() + "表达式类型无法识别");
        }

        return legalObjPack;
    }
}
