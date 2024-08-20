package com.cat.oqj4j.core;

import java.util.Collection;
import java.util.List;

/**
 * Oql客户端。
 * 提供Oql相关的功能，供调用者使用。
 *
 * @author gwj
 */
public interface OqlClient {
    /**
     * 执行Where条件 是否存在符合的记录
     * @param whereOqlExp where条件oql表达式
     * @param srcObj 提供操作的来源对象
     * @return true表示有符合where条件的记录，反之false。
     */
     <T> boolean doWhereExists(String whereOqlExp, T srcObj);

    /**
     * 执行Where条件 是否存在符合的记录
     * @param whereOqlExp where条件oql表达式
     * @param srcCol 提供操作的来源集合
     * @return true表示有符合where条件的记录，反之false。
     */
     <T> boolean doWhereExists(String whereOqlExp, Collection<T> srcCol);

    /**
     * 执行Where条件 统计符合的记录数
     * @param whereOqlExp where条件oql表达式
     * @param srcCol 提供操作的来源集合
     * @return 符合where条件的记录数
     */
    <T> int doWhereCount(String whereOqlExp, Collection<T> srcCol);

    /**
     * 执行Where条件 过滤出符合条件的记录
     * @param whereOqlExp where条件oql表达式
     * @param srcCol 提供操作的来源集合
     * @return 符合where条件的记录
     */
    <T> List<T> doWhereFilter(String whereOqlExp, Collection<T> srcCol);
}
