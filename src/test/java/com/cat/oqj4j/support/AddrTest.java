package com.cat.oqj4j.support;

/**
 * 地址测试
 * @author gwj
 */
public class AddrTest {
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 镇
     */
    private String town;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "AddrTest{" +
                "province=" + province +
                ", city=" + city +
                ", town=" + town +
                '}';
    }
}
