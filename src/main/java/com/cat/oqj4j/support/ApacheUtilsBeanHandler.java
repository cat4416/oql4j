package com.cat.oqj4j.support;

import com.cat.oqj4j.exception.BeanHandlingException;
import org.apache.commons.beanutils.NestedNullException;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * 基于apache的beanutils工具包的bean处理器
 *
 * @author gwj
 */
public class ApacheUtilsBeanHandler implements BeanHandler {

    @Override
    public <T> T getFieldVal(Object bean, String fieldName) throws BeanHandlingException {
        try {
            return (T) PropertyUtils.getProperty(bean, fieldName);
        }  catch(NestedNullException e) {
            // 嵌套值为空，直接返回null
            return null;
        }  catch(NoSuchMethodException e) {
            throw new BeanHandlingException(StrHelper.fillPlaceholder("获取{}字段值异常：{}", fieldName, e.getMessage()));
        } catch(Exception e) {
            throw new BeanHandlingException("获取" + fieldName + "字段值异常", e);
        }
    }

    @Override
    public void setFieldVal(Object bean, String fieldName, Object val) throws BeanHandlingException {
        try {
            PropertyUtils.setProperty(bean, fieldName, val);
        }  catch(NestedNullException e) {
            // 针对嵌套属性为null的情况，则尝试获执行恢复
            tryRecoverNestedNullException(bean, fieldName, val, e);
        }  catch(NoSuchMethodException e) {
            throw new BeanHandlingException(StrHelper.fillPlaceholder("设置{}字段值异常：{}", fieldName, e.getMessage()));
        } catch(Exception e) {
            throw new BeanHandlingException("设置" + fieldName +"字段值异常", e);
        }
    }

    /**
     * 尝试恢复嵌套空指针的异常
     * @param bean
     * @param fieldName
     * @param val
     * @param nestedEx
     * @throws BeanHandlingException
     */
    private void tryRecoverNestedNullException(Object bean, String fieldName, Object val, NestedNullException nestedEx) throws BeanHandlingException {
        try {
            // 父bean
            Object parenBean = bean;
            String[] fieldNameChips = fieldName.split("\\.");
            boolean isResolved = false;
            outFieldName: for (String fieldNameChip : fieldNameChips) {
                PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(parenBean.getClass());
                PropertyDescriptor targetDescriptor = null;
                for (PropertyDescriptor descriptor : propertyDescriptors) {
                    if (descriptor.getName().equals(fieldNameChip)) {
                        targetDescriptor = descriptor;
                        break;
                    }
                }
                if (targetDescriptor == null) {
                    throw new BeanHandlingException("无法获取到" + fieldNameChip + "字段的bean操作方法" );
                }
                Object curFieldVal = targetDescriptor.getReadMethod().invoke(parenBean);
                if (curFieldVal == null) {
                    Class propertyType = targetDescriptor.getPropertyType();
                    curFieldVal = ClassHelper.newInstance(propertyType);
                    if (propertyType.isInterface()) {
                        if (propertyType.equals(Map.class)) {
                            curFieldVal = new HashMap<>();
                        } else if (propertyType.equals(Collections.class)) {
                            curFieldVal = new ArrayList<>();
                        } else if (propertyType.equals(List.class)) {
                            curFieldVal = new ArrayList<>();
                        } else if (propertyType.equals(Set.class)) {
                            curFieldVal = new HashSet<>();
                        } else {
                            throw new BeanHandlingException(StrHelper.fillPlaceholder("{}字段的类型为{}，无法实例化",
                                    fieldNameChip, propertyType.getName()));
                        }
                    } else {
                        try {
                            curFieldVal = propertyType.newInstance();
                        } catch(Exception e) {
                            throw new BeanHandlingException(StrHelper.fillPlaceholder("{}字段的类型为{}，无法实例化",
                                    fieldNameChip, propertyType.getName()), e);
                        }
                    }

                    targetDescriptor.setValue(fieldNameChip, curFieldVal);
                    targetDescriptor.getWriteMethod().invoke(bean, curFieldVal);

                    isResolved = true;
                    break outFieldName;
                }

                // 进入下一个嵌套属性操作，字段值变为父bean
                parenBean = curFieldVal;
            }

            // 已解决问题，重新调用设置方法
            if (isResolved) {
                this.setFieldVal(bean, fieldName, val);
            } else {
                throw new BeanHandlingException(StrHelper.fillPlaceholder("嵌套设置{}字段值异常：{}", fieldName, nestedEx.getMessage()));
            }
        } catch(BeanHandlingException e) {
            throw e;
        } catch(Exception e) {
            throw new BeanHandlingException("设置" + fieldName +"字段值异常", e);
        }
    }

    public static void main(String[] args) {
        System.out.println("int.class.isPrimitive()=" + int.class.isPrimitive());
        System.out.println("Integer.class.isPrimitive()=" + Integer.class.isPrimitive());
        System.out.println("String.class.isPrimitive()=" + String.class.isPrimitive());

        Integer i = 3;
        System.out.println(i.getClass());
        System.out.println(i.getClass().isPrimitive());
    }

    @Override
    public void copyBean(Object dest, Object orig) throws BeanHandlingException {
        try {
            PropertyUtils.copyProperties(dest, orig);
        } catch(NoSuchMethodException e) {
            throw new BeanHandlingException("拷贝bean异常：" + e.getMessage());
        } catch(Exception e) {
            throw new BeanHandlingException("拷贝bean异常", e);
        }
    }
}
