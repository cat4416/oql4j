package com.cat.oqj4j.support;

import java.util.HashMap;
import java.util.Map;

/** 个人信息bean测试类
 * @author gwj
 */
public class PersonTest {
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 是否男性
     */
    private Boolean isMan;
    /**
     * 地址
     */
    private Map<String, String> addr;
    /**
     * 资产。使用基础类型测试。
     */
    private int property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAddr() {
        return addr;
    }

    public void setAddr(Map<String, String> addr) {
        this.addr = addr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsMan() {
        return isMan;
    }

    public void setIsMan(Boolean man) {
        isMan = man;
    }

    /**
     * 增加地址
     * @param key
     * @param val
     */
    public void addAddr(String key, String val) {
        if (addr == null) {
            addr = new HashMap<>();
        }
        addr.put(key, val);
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "PersonTest{" +
                "name=" + name +
                ", age=" + age +
                ", isMan=" + isMan +
                ", addr=" + addr +
                ", property=" + property +
                '}';
    }
}
