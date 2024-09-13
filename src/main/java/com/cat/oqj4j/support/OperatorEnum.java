package com.cat.oqj4j.support;

/**
 * 运算操作符枚举值
 *
 * @author gwj
 */
public enum OperatorEnum {
    /**
     * 等于操作符
     */
    EQ("="),
    /**
     * 大于操作符
     */
    GT(">"),
    /**
     * 小于操作符
     */
    LT("<"),
    /**
     * 大于等于操作符
     */
    GE(">="),
    /**
     * 小于操作符
     */
    LE("<="),
    /**
     * 不等于操作
     */
    NEQ("!="),
    /**
     *  不等于操作
     */
    NEQ2("<>");

    private String opeFlag;

    OperatorEnum(String opeFlag) {
        this.opeFlag = opeFlag;
    }

    /**
     * 获取操作符标记
     * @return 操作符标记
     */
    public String getOpeFlag() {
        return opeFlag;
    }

    /**
     * 解析操作符，转换为枚举对象
     * @param opeFlag 操作符
     * @return 枚举对象
     */
    public static OperatorEnum resolveOpeFlag(String opeFlag) {
        OperatorEnum[] values = OperatorEnum.values();
        for (OperatorEnum value : values) {
            if (value.getOpeFlag().equals(opeFlag)) {
                return value;
            }
        }
        throw new IllegalArgumentException(opeFlag + "操作符无法识别");
    }
}
