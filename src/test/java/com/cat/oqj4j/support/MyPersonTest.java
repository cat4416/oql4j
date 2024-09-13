package com.cat.oqj4j.support;

/** 我的个人信息bean测试类
 * @author gwj
 */
public class MyPersonTest {
    /**
     * 名称
     */
    private String myName;
    /**
     * 年龄
     */
    private Integer myAge;
    /**
     * 是否知道性别
     */
    private Boolean isKnownGender;
    /**
     * 地址
     */
    private AddrTest myAddr;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Integer getMyAge() {
        return myAge;
    }

    public void setMyAge(Integer myAge) {
        this.myAge = myAge;
    }

    public Boolean getKnownGender() {
        return isKnownGender;
    }

    public void setKnownGender(Boolean knownGender) {
        isKnownGender = knownGender;
    }

    public AddrTest getMyAddr() {
        return myAddr;
    }

    public void setMyAddr(AddrTest myAddr) {
        this.myAddr = myAddr;
    }

    @Override
    public String toString() {
        return "MyPersonTest{" +
                "myName='" + myName + '\'' +
                ", myAge=" + myAge +
                ", isKnownGender=" + isKnownGender +
                ", myAddr=" + myAddr +
                '}';
    }
}
