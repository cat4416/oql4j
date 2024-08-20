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
     * 地址
     */
    private Map<String, String> addr;

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

    @Override
    public String toString() {
        return "PersonTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr=" + addr +
                '}';
    }
}
