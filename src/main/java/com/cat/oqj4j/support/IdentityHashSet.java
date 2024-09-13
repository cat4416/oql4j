package com.cat.oqj4j.support;

import java.util.*;

/**
 * 一致性哈希集合类。
 * 基于 IdentityHashMap 类来实现。
 * 判断对象是否相同，采用 == 比较对象内存地址方式，判断对象是否实际为同一个引用。
 *
 *
 * @author gwj
 */
public class IdentityHashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable {
    private transient IdentityHashMap<E, Object> map;

    // 伪造Map的Value值
    private static final Object PRESENT = new Object();


    /**
     * 构造对象。默认初始容量为21。
     */
    public IdentityHashSet() {
        map = new IdentityHashMap<>();
    }

    /**
     * 构造对象，并传入需要包含的集合
     * @param c 初始集合元素
     */
    public IdentityHashSet(Collection<? extends E> c) {
        map = new IdentityHashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }

    /**
     * 构造对象，并指定初始容量
     * @param initialCapacity 初始容量
     */
    public IdentityHashSet(int initialCapacity) {
        map = new IdentityHashMap<>(initialCapacity);
    }


    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.isEmpty() ? false : map.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            IdentityHashSet<E> newSet = (IdentityHashSet<E>) super.clone();
            newSet.map = (IdentityHashMap<E, Object>) map.clone();
            return newSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

}
