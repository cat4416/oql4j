package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.antlr.type.CondExpType;
import com.cat.oqj4j.antlr.type.ConstValExpType;
import com.cat.oqj4j.antlr.type.DynamicValExpType;
import com.cat.oqj4j.antlr.type.ExpType;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.LegalObjPack;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Deque;

/**
 * 抽象的条件表达式处理类
 * @author gwj
 */
public abstract class AbstractCondHandler<T extends CondExpType> implements CondHandler<T>{

    @Override
    public LegalObjPack handleCond(T condExpType, Deque<ExpType> nodeStack, Collection<Object> srcCol) {
        // 弹出操作字段
        ExpType nameExp = nodeStack.removeLast();
        LegalObjPack legalObjPack;
        try {
            if (nameExp instanceof DynamicValExpType) {
                legalObjPack = this.handleDynamicExpCond(condExpType, (DynamicValExpType) nameExp, nodeStack, srcCol);
            } else if (nameExp instanceof ConstValExpType) {
                legalObjPack = this.handleConstExpCond(condExpType, (ConstValExpType) nameExp, nodeStack, srcCol);
            }  else {
                throw new OqlExpResolvedException(nameExp.getExp() + "表达式类型无法识别");
            }
        } catch (OqlExpResolvedException e) {
            throw e;
        } catch (Exception e) {
            throw new OqlExpResolvedException(nameExp.getExp() + "表达式处理异常", e);
        }
        // 如果达到合法数量转移为全部符合，提高后续操作的性能和空间
        legalObjPack.transferAllSatisfiedIf(srcCol.size());

        return legalObjPack;
    }

    /**
     * 处理动态表达式值的条件
     * @param condExpType 条件表达式
     * @param nameExp 操作的名称表达式
     * @param nodeStack 节点栈
     * @param srcCol 操作原对象集合
     * @return 合法对象封装
     */
    protected abstract LegalObjPack handleDynamicExpCond(T condExpType, DynamicValExpType nameExp,
                                                         Deque<ExpType> nodeStack, Collection<Object> srcCol);

    /**
     * 处理常量表达式值的条件
     * @param condExpType 条件表达式
     * @param nameExp 操作的名称表达式
     * @param nodeStack 节点栈
     * @param srcCol 操作原对象集合
     * @return 合法对象封装
     */
    protected abstract LegalObjPack handleConstExpCond(T condExpType, ConstValExpType nameExp,
                                                       Deque<ExpType> nodeStack, Collection<Object> srcCol);



    @Override
    @SuppressWarnings(("unchecked"))
    public Class<T> getSupportedExpType() {
        final ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) pt.getActualTypeArguments()[0];
    }
}
