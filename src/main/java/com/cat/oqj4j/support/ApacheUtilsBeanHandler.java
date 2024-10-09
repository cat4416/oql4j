package com.cat.oqj4j.support;

import com.cat.oqj4j.exception.BeanHandlingException;
import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.converters.BooleanConverter;

import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * 基于apache的beanutils工具包的bean处理器
 *
 * @author gwj
 */
@SuppressWarnings("unchecked")
public class ApacheUtilsBeanHandler implements BeanHandler {

    private ConvertUtilsBean convertUtils;

    /**
     * 构建对象
     */
    public ApacheUtilsBeanHandler() {
        // 对默认的转换工具类进行定制化
        convertUtils = BeanUtilsBean.getInstance().getConvertUtils();
        // 设置bean工具的转换原则，如果转换失败直接抛出异常，不给默认值
        convertUtils.register(true, true, -1);

        // 对于布尔值的转换，指定字符才可转换布尔值
        String[] trueStrings = {"true", "1"};
        String[] falseStrings = {"false", "0"};
        BooleanConverter booleanConverter = new BooleanConverter(trueStrings, falseStrings);
        convertUtils.register(booleanConverter, Boolean.TYPE);
        convertUtils.register(booleanConverter, Boolean.class);
    }

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
        } catch(NestedNullException e) {
            // 针对嵌套属性为null的情况，则尝试获执行恢复
            tryRecoverNestedNullException(bean, fieldName, val, e);
        } catch(IllegalArgumentException e) {
            // 针对值类型不对应的情况，则尝试获执行恢复
            tryRecoverIllegalArgumentException(bean, fieldName, val, e);
        } catch(NoSuchMethodException e) {
            throw new BeanHandlingException(StrHelper.fillPlaceholder("设置{}字段值异常：{}", fieldName, e.getMessage()));
        } catch(Exception e) {
            throw new BeanHandlingException("设置" + fieldName +"字段值异常", e);
        }
    }

    /**
     * 尝试恢复嵌套空指针的异常
     * @param bean 操作对象
     * @param fieldName 字段名称
     * @param val 字段值
     * @param nestedEx 内嵌空属性异常
     * @throws BeanHandlingException bean处理异常
     */
    private void tryRecoverNestedNullException(Object bean, String fieldName, Object val,
                                               NestedNullException nestedEx) throws BeanHandlingException {
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

    /**
     * 尝试恢复非法参数的异常
     * @param bean 操作对象
     * @param fieldName 字段名称
     * @param val 字段值
     * @param argEx 非法参数的异常
     * @throws BeanHandlingException bean处理异常
     */
    private void tryRecoverIllegalArgumentException(Object bean, String fieldName, Object val,
                                               IllegalArgumentException argEx) throws BeanHandlingException {
        try {
            // 父bean
            Object parenBean = bean;
            String[] fieldNameChips = fieldName.split("\\.");
            boolean isResolved = false;
            outFieldName: for (int i = 0; i < fieldNameChips.length; i++) {
                String fieldNameChip = fieldNameChips[i];
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
                // 对最后个字段进行类型转换
                if (i == fieldNameChips.length - 1) {
                    Converter converter = convertUtils.lookup(targetDescriptor.getPropertyType());
                    if (converter == null) {
                        throw new BeanHandlingException(val.getClass() + "字段值的类型无对应转换器" );
                    }
                    // 将字段值转换为目标值
                    val = converter.convert(targetDescriptor.getPropertyType(), val);
                    isResolved = true;
                    break outFieldName;
                } else {
                    // 进入下一个嵌套字段的循环处理
                    parenBean = targetDescriptor.getReadMethod().invoke(parenBean);
                }
            }

            // 已解决问题，重新调用设置方法
            if (isResolved) {
                this.setFieldVal(bean, fieldName, val);
            } else {
                throw new BeanHandlingException(StrHelper.fillPlaceholder("设置{}字段值进行类型转换异常：{}", fieldName, argEx.getMessage()));
            }
        } catch(BeanHandlingException e) {
            throw e;
        } catch(Exception e) {
            throw new BeanHandlingException("设置" + fieldName +"字段值异常", e);
        }
    }



    @Override
    public void copyBean(Object dest, Object orig, boolean isStrictType) throws BeanHandlingException {
        try {
            // 根据是否严格模式采用不同的赋值工具
            if (isStrictType) {
                PropertyUtils.copyProperties(dest, orig);
            } else {
                BeanUtils.copyProperties(dest, orig);
            }
        } catch(NoSuchMethodException e) {
            throw new BeanHandlingException("拷贝bean异常：" + e.getMessage());
        } catch(Exception e) {
            throw new BeanHandlingException("拷贝bean异常", e);
        }
    }
}
