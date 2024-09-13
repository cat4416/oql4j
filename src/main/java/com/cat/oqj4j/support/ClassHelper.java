package com.cat.oqj4j.support;

import java.util.*;

/**
 * Class字节码操作助手类
 * @author gwj
 */
public abstract class ClassHelper {
    /**
     * 创建新的实例
     * @param clazz 字节码
     * @param <T> 目标类型
     * @return 实例化对象
     * @throws InstantiationException 实例化失败将抛出此异常
     */
    public static <T> T newInstance(Class<? super T> clazz) throws InstantiationException {
        T instance = null;
         try {
             if (clazz.isInterface()) {
                 // 对集合接口进行特殊转化
                 if (clazz.equals(Map.class)) {
                     instance = (T) new HashMap();
                 } else if (clazz.equals(Collection.class)) {
                     instance = (T) new ArrayList();
                 } else if (clazz.equals(List.class)) {
                     instance = (T) new ArrayList();
                 } else if (clazz.equals(Set.class)) {
                     instance = (T) new HashSet();
                 }
             } else {
                 instance = (T) clazz.newInstance();
             }

             if (instance == null) {
                 throw new InstantiationException(clazz + " 无法进行实例化");
             }

         } catch(InstantiationException e) {
             throw e;
         } catch(Exception e) {
             throw new InstantiationException(clazz + " 实例化失败:" + e.getMessage());
         }

        return instance;
    }
}
