package com.cat.oqj4j.support;

import java.util.Collection;

/**
 * 函数处理器 上下文
 * @author gwj
 */
public class FunHandlerContext {
    /**
     * 原对象集合
     */
    private Collection<?> srcCol;
    /**
     * 当前处理对象
     */
    private Object curObj;
    /**
     * 参数
     */
    private Object[] args;

    /**
     * 构造对象
     */
    public FunHandlerContext() {
    }

    /**
     *  构造对象
     * @param srcCol 原对象集合
     * @param curObj 当前处理对象
     * @param args 参数
     */
    public FunHandlerContext(Collection<?> srcCol, Object curObj, Object[] args) {
        this.srcCol = srcCol;
        this.curObj = curObj;
        this.args = args;
    }

    public Collection<?> getSrcCol() {
        return srcCol;
    }

    public void setSrcCol(Collection<?> srcCol) {
        this.srcCol = srcCol;
    }

    public Object getCurObj() {
        return curObj;
    }

    public void setCurObj(Object curObj) {
        this.curObj = curObj;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
