package com.cat.oqj4j.core;

import com.cat.oqj4j.antlr.listener.SelectStatementListener;
import com.cat.oqj4j.antlr.listener.UpdateStatementListener;
import com.cat.oqj4j.support.StrHelper;
import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.antlr.listener.WhereStatementListener;
import com.cat.oqj4j.exception.BeanHandlingException;
import com.cat.oqj4j.exception.OqlExpResolvedException;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 默认的Oql客户端实现类。
 * ps：此类是线程安全的，可以作为单例使用。
 *
 * @author gwj
 */
@ThreadSafe
public class DefaultOqlClientImpl implements OqlClient {
    /**
     * oql核心剖面
     */
    private OqlCoreProfile coreProfile;
    /**
     * antlr执行器
     */
    private AntlrLauncher antlrLauncher = AntlrLauncher.getInstance();

    /**
     * 构建客户端。使用默认级别的访问权限，控制外部构建此对象。
     * @param coreProfile
     */
    DefaultOqlClientImpl(OqlCoreProfile coreProfile) {
        this.coreProfile = coreProfile;
    }

    @Override
    public <T> boolean doWhereExists(String whereOqlExp, T srcObj) {
        if (srcObj == null) {
            throw new IllegalArgumentException("操作对象不能为空");
        }
        return this.doWhereExists(whereOqlExp, Arrays.asList(srcObj));
    }

    @Override
    public <T> boolean doWhereExists(String whereOqlExp, Collection<T> srcCol) {
        return this.execWhereExp(whereOqlExp, srcCol).getBolResult();
    }

    @Override
    public <T> int doWhereCount(String whereOqlExp, Collection<T> srcCol) {
        return this.execWhereExp(whereOqlExp, srcCol).getCountResult();
    }

    @Override
    public <T> List<T> doWhereFilter(String whereOqlExp, Collection<T> srcCol) {
        return this.execWhereExp(whereOqlExp, srcCol).getColResult();
    }

    @Override
    public <T> T doSelect(String selectOqlExp, Object srcObj, Class<T> targetClass) {
        List<T> ts = this.doSelect(selectOqlExp, null, Arrays.asList(srcObj), targetClass);
        return ts.get(0);
    }

    @Override
    public <T> List<T> doSelect(String selectOqlExp, Collection<?> srcCol, Class<T> targetClass) {
        return this.doSelect(selectOqlExp, null, srcCol, targetClass);
    }


    @Override
    public <T> List<T> doSelect(String selectOqlExp, String whereOqlExp, Collection<?> srcCol, Class<T> targetClass) {
        if (targetClass == null) {
            throw new IllegalArgumentException("封装数据的目标类型不能为空");
        }
        Collection<?> useSrcCol = srcCol;
        // 判断where条件表达式是否存在
        if (StrHelper.isNotBlank(whereOqlExp)) {
            // 先执行where表达式，获得符合条件的数据
            useSrcCol = this.doWhereFilter(whereOqlExp, useSrcCol);
        }
        // 执行select映射
        SelectStatementListener selectStatementListener = execSelectExp(selectOqlExp, useSrcCol);
        try {
            return selectStatementListener.getResult(targetClass);
        } catch (InstantiationException | BeanHandlingException beanEx) {
            throw new OqlExpResolvedException(targetClass + "操作异常", beanEx);
        }
    }

    @Override
    public List<Map<String, Object>> doSelect(String selectOqlExp, String whereOqlExp, Collection<?> srcCol) {
        Collection<?> useSrcCol = srcCol;
        // 判断where条件表达式是否存在
        if (StrHelper.isNotBlank(whereOqlExp)) {
            // 先执行where表达式，获得符合条件的数据
            useSrcCol = this.doWhereFilter(whereOqlExp, useSrcCol);
        }
        // 执行select映射
        SelectStatementListener selectStatementListener = execSelectExp(selectOqlExp, useSrcCol);
        return selectStatementListener.getMapResult();
    }

    @Override
    public Map<String, Object> doSelect(String selectOqlExp, Object srcObj) {
        if (srcObj == null) {
            throw new IllegalArgumentException("操作对象不能为空");
        }
        List<Map<String, Object>> maps = this.doSelect(selectOqlExp, null, Arrays.asList(srcObj));
        return maps.get(0);
    }

    @Override
    public int doUpdate(String updateOqlExp, Object srcObj) {
        if (srcObj == null) {
            throw new IllegalArgumentException("操作对象不能为空");
        }
        return this.doUpdate(updateOqlExp, Arrays.asList(srcObj));
    }

    @Override
    public int doUpdate(String updateOqlExp, Collection<?> srcCol) {
        return this.doUpdate(updateOqlExp, null, srcCol);
    }

    @Override
    public int doUpdate(String updateOqlExp, String whereOqlExp, Collection<?> srcCol) {
        Collection<?> useSrcCol = srcCol;
        // 判断where条件表达式是否存在
        if (StrHelper.isNotBlank(whereOqlExp)) {
            // 先执行where表达式，获得符合条件的数据
            useSrcCol = this.doWhereFilter(whereOqlExp, useSrcCol);
        }
        // 执行update更新
        return this.execUpdateExp(updateOqlExp, useSrcCol).getUpdateRecord();
    }

    /**
     * 执行where条件表达式
     * @param whereOqlExp where条件oql表达式
     * @param srcCol 提供操作的来源集合
     * @return where条件监听器
     */
    private <T> WhereStatementListener execWhereExp(String whereOqlExp, Collection<T> srcCol) {
        // 执行语法遍历
        WhereStatementListener<T> listener = new WhereStatementListener(this.coreProfile, srcCol);
        antlrLauncher.emitWhereWalk(whereOqlExp, listener);
        return listener;
    }

    /**
     * 执行select映射表达式
     * @param selectOqlExp select映射oql表达式
     * @param srcCol 提供操作的来源集合
     * @return select映射监听器
     */
    private SelectStatementListener execSelectExp(String selectOqlExp, Collection<?> srcCol) {
        // 执行语法遍历
        SelectStatementListener listener = new SelectStatementListener(this.coreProfile, srcCol);
        antlrLauncher.emitSelectWalk(selectOqlExp, listener);
        return listener;
    }

    /**
     * 执行update更新表达式
     * @param updateOqlExp update的oql表达式
     * @param srcCol 提供操作的来源集合
     * @return update更新监听器
     */
    private UpdateStatementListener execUpdateExp(String updateOqlExp, Collection<?> srcCol) {
        // 执行语法遍历
        UpdateStatementListener listener = new UpdateStatementListener(this.coreProfile, srcCol);
        antlrLauncher.emitUpdateWalk(updateOqlExp, listener);
        return listener;
    }


}
