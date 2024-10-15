package com.cat.oqj4j.antlr.type;

import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.BeanHandlingException;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.AntlrHelper;
import com.cat.oqj4j.support.BeanHandler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 列表值类型表达式
 * @author gwj
 */
public class ListValExpType implements DynamicValExpType {
    /**
     * 表达式
     */
    private String exp;
    /**
     * 核心剖面
     */
    private OqlCoreProfile oqlCore;

    /**
     * 操作原对象集合
     */
    private Collection<?> srcCol;
    /**
     * 包含的元素值表达式类型集合。
     * ps：[10,20,${city}] 则说明有3个参数
     */
    private List<ValExpType> elementExpTypes;

    /**
     * 构造对象
     * @param exp 表达式
     * @param oqlCore 核心剖面
     * @param srcCol 原对象集合
     */
    public ListValExpType(String exp, OqlCoreProfile oqlCore, Collection<?> srcCol) {
        this.exp = exp;
        this.srcCol = srcCol;
        this.oqlCore = oqlCore;
    }

    /**
     * 增加元素的表达性类型
     * @param expType 表达式类型
     */
    public void addElementExpTypes(ValExpType expType) {
        if (elementExpTypes == null) {
            elementExpTypes = new ArrayList<>();
        }
        elementExpTypes.add(expType);
    }

    /**
     * 反转元素顺序
     */
    public void reverseElement() {
        if (elementExpTypes != null && elementExpTypes.size() > 1) {
            Collections.reverse(elementExpTypes);
        }
    }



    @Override
    public String getExp() {
        return this.exp;
    }


    @Override
    public Object getVal(Object srcObj) {
        try {
            List<Object> list;
            if (elementExpTypes != null && !elementExpTypes.isEmpty()) {
                list = new ArrayList<>(elementExpTypes.size());
                for (int i = 0; i < elementExpTypes.size(); i++) {
                    ValExpType elementExpType = elementExpTypes.get(i);
                    Object val = AntlrHelper.getExpVal(srcObj, elementExpType);
                    list.add(val);
                }
            } else {
                list = Collections.emptyList();
            }
            return list;
        } catch(Exception e) {
            throw new OqlExpResolvedException(this.exp + "表达式处理失败", e);
        }
    }
}
