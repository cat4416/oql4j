package com.cat.oqj4j.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 线程安全注解。使用此注解的类，表示是并发情况下线程安全的，可作为单例使用。
 * @author gwj
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ThreadSafe {
}
