package com.cat.oqj4j.support;

import com.cat.oqj4j.core.AntlrLauncher;
import com.cat.oqj4j.exception.OqlExpResolvedException;

/**
 * 语法检查助手
 *
 * @author gwj
 */
public abstract class GrammarCheckHelper {
    /**
     * 检查 where条件表达式
     * @param whereOqlExp 表达式
     * @throws OqlExpResolvedException 检查不通过时，抛出此异常
     */
    public static void checkWhereExp(String whereOqlExp) throws OqlExpResolvedException {
        try {
            AntlrLauncher.getInstance().emitWhereWalk(whereOqlExp);
        } catch(OqlExpResolvedException e) {
            throw e;
        } catch(Exception e) {
            throw new OqlExpResolvedException("表达式非法", e);
        }
    }

    /**
     * 核实 where条件表达式 是否合法
     * @param whereOqlExp 表达式
     * @return true表示合法，false表示非法。
     */
    public static boolean verifyWhereExp(String whereOqlExp) {
        boolean legal = true;
        try {
            AntlrLauncher.getInstance().emitWhereWalk(whereOqlExp);
        } catch(OqlExpResolvedException e) {
            legal = false;
        }
        return legal;
    }

    /**
     * 检查 select映射表达式
     * @param selectOqlExp 表达式
     * @throws OqlExpResolvedException 检查不通过时，抛出此异常
     */
    public static void checkSelectExp(String selectOqlExp) throws OqlExpResolvedException {
        try {
            AntlrLauncher.getInstance().emitSelectWalk(selectOqlExp);
        } catch(OqlExpResolvedException e) {
            throw e;
        } catch(Exception e) {
            throw new OqlExpResolvedException("表达式非法", e);
        }
    }

    /**
     * 核实 select映射表达式 是否合法
     * @param selectOqlExp 表达式
     * @return true表示合法，false表示非法。
     */
    public static boolean verifySelectExp(String selectOqlExp) {
        boolean legal = true;
        try {
            AntlrLauncher.getInstance().emitSelectWalk(selectOqlExp);
        } catch(OqlExpResolvedException e) {
            legal = false;
        }
        return legal;
    }



    /**
     * 检查 update更新表达式
     * @param updateOqlExp 表达式
     * @throws OqlExpResolvedException 检查不通过时，抛出此异常
     */
    public static void checkUpdateExp(String updateOqlExp) throws OqlExpResolvedException {
        try {
            AntlrLauncher.getInstance().emitUpdateWalk(updateOqlExp);
        } catch(OqlExpResolvedException e) {
            throw e;
        } catch(Exception e) {
            throw new OqlExpResolvedException("表达式非法", e);
        }
    }

    /**
     * 核实 update更新表达式 是否合法
     * @param updateOqlExp 表达式
     * @return true表示合法，false表示非法。
     */
    public static boolean verifyUpdateExp(String updateOqlExp) {
        boolean legal = true;
        try {
            AntlrLauncher.getInstance().emitUpdateWalk(updateOqlExp);
        } catch(OqlExpResolvedException e) {
            legal = false;
        }
        return legal;
    }


}
