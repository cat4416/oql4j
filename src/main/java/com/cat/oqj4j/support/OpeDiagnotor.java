package com.cat.oqj4j.support;

import com.cat.oqj4j.annotation.ThreadSafe;

import java.math.BigDecimal;

/**
 *  运算操作符诊断器。
 *  用于根据操作符求值，获得判断结果值。
 *
 * @author gwj
 */
@ThreadSafe
public class OpeDiagnotor {
    private static final OpeDiagnotor opeDiagnotor = new OpeDiagnotor();

    /**
     * 限制对象的创建
     */
    private OpeDiagnotor() {
    }

    /**
     * 获取实例对象
     * @return
     */
    public static OpeDiagnotor getInstance() {
        return opeDiagnotor;
    }

    /**
     * 诊断
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @param ope 操作符枚举值
     * @return 诊断结果
     */
    public boolean diagnose(Object obj1, Object obj2, OperatorEnum ope) {
        boolean result;
        switch (ope) {
            case EQ:
                result = diagnoseEQ(obj1, obj2);
                break;

            case GT:
                result = diagnoseGT(obj1, obj2);
                break;

            case LT:
                result = diagnoseLT(obj1, obj2);
                break;

            case GE:
                result = diagnoseGE(obj1, obj2);
                break;

            case LE:
                result = diagnoseLE(obj1, obj2);
                break;

            case NEQ:
                result = diagnoseNEQ(obj1, obj2);
                break;

            default:
                throw new UnsupportedOperationException(ope.getOpeFlag() + "是不支持的操作符");
        }

        return result;
    }

    /**
     * 诊断 =等于操作符
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @return 诊断结果
     */
    public boolean diagnoseEQ(Object obj1, Object obj2) {
        /**
         * 按规则优先级诊断：
         * 1、如果均为null，则认为相同。
         * 2、如果仅有一个对象为null，则认为均不同。
         * 3、如果是相同类型，则直接调用对象的equalse方法比较。
         * 4、如果类型不同，则判断是否有 布尔值，如果有布尔值，则使用布尔值进行比较(0和false字符串都属于假，1和true字符串则属于真)。
         * 5、如果都是属于Number及其子类，则转换为浮点型比较。
         * 6、如果是原始类型或者字符串类型，统一获取对象字符串进行比较。
         */
        if (obj1 == null && obj2 == null) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        // 规则3
        if (obj1.getClass() == obj2.getClass()) {
            return obj1.equals(obj2);
        }
        // 规则4
        if (obj1 instanceof Boolean) {
            Boolean obj2Boolean = this.tryDiagnosticBool(obj2);
            if (obj2Boolean != null) {
                return obj1.equals(obj2Boolean);
            }
        }
        if (obj2 instanceof Boolean) {
            Boolean obj1Boolean = this.tryDiagnosticBool(obj1);
            if (obj1Boolean != null) {
                return obj2.equals(obj1Boolean);
            }
        }
        // 规则5
        if (obj1 instanceof Number && obj2 instanceof Number) {
            return ((Number) obj1).doubleValue() == ((Number) obj2).doubleValue();
        }

        // 规则6
        boolean isObj1Primitive = obj1.getClass().isPrimitive() || (obj1 instanceof String);
        boolean isObj2Primitive = obj2.getClass().isPrimitive() || (obj2 instanceof String);
        if (isObj1Primitive && isObj2Primitive) {
            return obj1.toString().equals(obj2.toString());
        }

        return false;
    }

    /**
     * 诊断 >大于操作符，即要求obj1大于obj2
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @return 诊断结果
     */
    public boolean diagnoseGT(Object obj1, Object obj2) {
        /**
         * 按规则优先级诊断：
         * 1、如果存在有对象为null，则认为均不同。
         * 2、如果对象均为BigDecimal，转为BigDecimal进行比较。
         * 3、如果都是属于Number及其子类，则转换为浮点型比较。
         * 4、如果存在有对象为布尔值，则认为均不同。
         * 5、如果是原始类型或者字符串类型，统一获取对象字符串进行比较(先比较长度，然后在比较asscii码值)。
         */
        if (obj1 == null || obj2 == null) {
            return false;
        }
        if (obj1 instanceof BigDecimal && obj2 instanceof BigDecimal) {
            return ((BigDecimal) obj1).compareTo((BigDecimal)obj2) > 0;
        }

        // 规则3
        if (obj1 instanceof Number && obj2 instanceof Number) {
            return ((Number) obj1).doubleValue() > ((Number) obj2).doubleValue();
        }

        // 规则4
        if (obj1 instanceof Boolean || obj2 instanceof Boolean) {
            return false;
        }

        // 规则5
        boolean isObj1Primitive = obj1.getClass().isPrimitive() || (obj1 instanceof String);
        boolean isObj2Primitive = obj2.getClass().isPrimitive() || (obj2 instanceof String);
        if (isObj1Primitive && isObj2Primitive) {
            String obj1Str = obj1.toString();
            String obj2Str = obj2.toString();
            // 长度不一样，则直接比较长度
            if (obj1Str.length() != obj2Str.length()) {
                return obj1Str.length() > obj2Str.length();
            }
            // 如果长度一样，则根据asscii码值比较
            int len = obj1Str.length();
            for (int i = 0; i < len; i++) {
                if (obj1Str.charAt(i) != obj2Str.charAt(2)) {
                    return obj1Str.charAt(i) > obj2Str.charAt(2);
                }
            }
            // 长度一样，并且asscii码值相同，直接返回true
            return true;
        }

        return false;
    }

    /**
     * 诊断 <小于操作符，即要求obj1小于obj2
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @return 诊断结果
     */
    public boolean diagnoseLT(Object obj1, Object obj2) {
        /**
         * 按规则优先级诊断：
         * 1、如果存在有对象为null，则认为均不同。
         * 2、如果对象均为BigDecimal，转为BigDecimal进行比较。
         * 3、如果都是属于Number及其子类，则转换为浮点型比较。
         * 4、如果存在有对象为布尔值，则认为均不同。
         * 5、如果是原始类型或者字符串类型，统一获取对象字符串进行比较(先比较长度，然后在比较asscii码值)。
         */
        if (obj1 == null || obj2 == null) {
            return false;
        }
        if (obj1 instanceof BigDecimal && obj2 instanceof BigDecimal) {
            return ((BigDecimal) obj1).compareTo((BigDecimal)obj2) < 0;
        }
        // 规则3
        if (obj1 instanceof Number && obj2 instanceof Number) {
            return ((Number) obj1).doubleValue() < ((Number) obj2).doubleValue();
        }
        // 规则4
        if (obj1 instanceof Boolean || obj2 instanceof Boolean) {
            return false;
        }

        // 规则5
        boolean isObj1Primitive = obj1.getClass().isPrimitive() || (obj1 instanceof String);
        boolean isObj2Primitive = obj2.getClass().isPrimitive() || (obj2 instanceof String);
        if (isObj1Primitive && isObj2Primitive) {
            String obj1Str = obj1.toString();
            String obj2Str = obj2.toString();
            // 长度不一样，则直接比较长度
            if (obj1Str.length() != obj2Str.length()) {
                return obj1Str.length() > obj2Str.length();
            }
            // 如果长度一样，则根据asscii码值比较
            int len = obj1Str.length();
            for (int i = 0; i < len; i++) {
                if (obj1Str.charAt(i) != obj2Str.charAt(2)) {
                    return obj1Str.charAt(i) < obj2Str.charAt(2);
                }
            }
            // 长度一样，并且asscii码值相同，直接返回true
            return true;
        }

        return false;
    }

    /**
     * 诊断 >=大于等于操作符
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @return 诊断结果
     */
    public boolean diagnoseGE(Object obj1, Object obj2) {
        return this.diagnoseGT(obj1, obj2) || this.diagnoseEQ(obj1, obj2);
    }


    /**
     * 诊断 <=小于操作符
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @return 诊断结果
     */
    public boolean diagnoseLE(Object obj1, Object obj2) {
        return this.diagnoseLT(obj1, obj2) || this.diagnoseEQ(obj1, obj2);
    }

    /**
     * 诊断 不等于操作（包含!=和<>）
     * @param obj1 比较对象1
     * @param obj2 比较对象2
     * @return 诊断结果
     */
    public boolean diagnoseNEQ(Object obj1, Object obj2) {
        return !this.diagnoseEQ(obj1, obj2);
    }

    /**
     * 尝试诊断布尔值。
     * 诊断规则如下：
     *  1、如果obj参数为null，则认为无法诊断。
     *  1、如果obj参数是布尔值，则直接返回对应布尔值。
     *  2、如果obj参数是Number，则如果数值为0表示false，为1表示true，其他数值则认为无法诊断。
     *  3、如果对象为String字符串，则false和0字符串表示false，true和1字符串为true，并且不区分大小写。其他字符串则认为无法诊断。
     * @param obj 对象
     * @return 布尔值结果。如果无法诊断，则返回null。
     */
    public Boolean tryDiagnosticBool(Object obj) {
        Boolean result = null;
        if (obj != null) {
            if (obj instanceof Boolean) {
                result = (Boolean) obj;
            } else if (obj instanceof Number) {
                double objDouble = ((Number) obj).doubleValue();
                if (objDouble == 1) {
                    result = Boolean.TRUE;
                } else if (objDouble == 0.0) {
                    result = Boolean.FALSE;
                }
            } else if (obj instanceof String) {
                String objStr = obj.toString();
                if (objStr.equalsIgnoreCase("true") || objStr.equals("1")) {
                    result = Boolean.TRUE;
                } else if (objStr.equalsIgnoreCase("false") || objStr.equals("0")) {
                    result = Boolean.FALSE;
                }
            }
        }

        return result;
    }

}
