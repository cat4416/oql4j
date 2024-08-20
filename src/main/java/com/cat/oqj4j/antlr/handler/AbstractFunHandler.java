package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.StrHelper;

import java.util.Collection;

/**
 * 抽象的函数表达式处理类
 * @author gwj
 */
public abstract class AbstractFunHandler implements FunHandler {
    /**
     * 参数不限制
     */
    protected static final int ARG_NO_LIMIT = -1;
    /**
     * 空参数
     */
    private static final Object[] EMPTY_ARGS = new Object[]{};

    @Override
    public final Object handleFun(Collection<?> srcCol, Object curObj, Object... args) {
        try {
            if (args == null) {
                args = EMPTY_ARGS;
            }
            if (this.getRequiredArgsSize() !=ARG_NO_LIMIT) {
                if (args.length != this.getRequiredArgsSize()) {
                    throw new IllegalArgumentException(
                            StrHelper.fillPlaceholder("需要{}个参数，实际请求参数有{}个",
                                    this.getRequiredArgsSize(), args.length));
                }
            }
            if (this.getMaxArgsSize() !=ARG_NO_LIMIT) {
                if (args.length > this.getMaxArgsSize()) {
                    throw new IllegalArgumentException(
                            StrHelper.fillPlaceholder("最多只能有{}个参数，实际请求参数有{}个",
                                    this.getMaxArgsSize(), args.length));
                }
            }
            if (!isAllowNullArgElement()) {
                if (args.length > 0) {
                    for (Object arg : args) {
                        if (arg == null) {
                            throw new IllegalArgumentException("args参数里存在null元素");
                        }
                    }
                }
            }

            return this.handleActually(srcCol, curObj, args);
        }  catch (OqlExpResolvedException e) {
            throw e;
        } catch (Exception e) {
            throw new OqlExpResolvedException(this.getSupportedFunName() + "函数处理异常", e);
        }
    }

    /**
     * 实际的函数处理方法
     * @param srcCol 原对象集合
     * @param curObj 当前处理对象
     * @param args 参数。非空。如果参数不存在，则传入空数组。
     * @return 处理结果
     */
    protected abstract Object handleActually(Collection<?> srcCol, Object curObj, Object[] args);

    /**
     * 需要的arg参数数量
     * @return 参数数量。如果返回-1则表示不限制
     */
    protected int getRequiredArgsSize() {
        return ARG_NO_LIMIT;
    };

    /**
     * 最大的参数数量（大于等于）
     * @return 最大参数数量。如果返回-1则表示不限制
     */
    protected int getMaxArgsSize() {
        return ARG_NO_LIMIT;
    };

    /**
     * 是否允许null的arg参数元素
     * @return true表示允许
     */
    protected boolean isAllowNullArgElement() {
        return true;
    }
}
