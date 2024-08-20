package com.cat.oqj4j.antlr.type;

import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.OqlExpResolvedException;

/**
 * 字段取值占位符的值类型表达式
 *
 * @author gwj
 */
public class FieldPlaceValExpType implements DynamicValExpType {
    /**
     * 表达式
     */
    private String exp;
    /**
     * 核心剖面
     */
    private OqlCoreProfile oqlCore;

    /**
     * 构造对象
     * @param exp 表达式
     * @param oqlCore 核心剖面
     */
    public FieldPlaceValExpType(String exp, OqlCoreProfile oqlCore) {
        this.exp = exp;
        this.oqlCore = oqlCore;
    }

    @Override
    public String getExp() {
        return this.exp;
    }


    @Override
    public Object getVal(Object srcObj) {
        try {
            // 取值表达式格式${fieldName}，需要取出fieldName
            String fieldName = exp.replaceFirst("\\$\\{(.*)\\}", "$1");
            return oqlCore.getBeanHandler().getFieldVal(srcObj, fieldName);
        } catch (OqlExpResolvedException e) {
            throw e;
        } catch (Exception e) {
            throw new OqlExpResolvedException("处理" + exp + "表达式异常", e);
        }
    }
}
