package com.cat.oqj4j.support;

import com.cat.oqj4j.exception.BeanHandlingException;
import org.apache.commons.beanutils.PropertyUtils;

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
        }  catch(NoSuchMethodException e) {
            throw new BeanHandlingException(StrHelper.fillPlaceholder("设置{}字段值异常：{}", fieldName, e.getMessage()));
        } catch(Exception e) {
            throw new BeanHandlingException("设置" + fieldName +"字段值异常", e);
        }
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
