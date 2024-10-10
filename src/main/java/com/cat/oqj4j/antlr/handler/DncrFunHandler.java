package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.FunHandlerContext;

import java.math.BigDecimal;

/**
 *  Dncr函数处理器，用于对arg1参数进行累减，累减步长为arg2。
 *  ps：
 *      1、如果arg2参数为null，则默认步长为1。
 *
 * 例如： ${Dncr(arg1, arg2)}。
 * @author gwj
 */
public class DncrFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(FunHandlerContext context) {
        Object[] args = context.getArgs();
        /**
         * 做优化处理：
         *  1、如果减数和步长都是Integer类型，则直接用Integer来计算，并返回Integer类型。
         *  2、如果减数和步长都为Long类型或者包含Integer类型，则直接用Long来计算，并返回Long类型。
         *  3、如果并不是Integer或者Long类型，则默认使用BigDecimal类型来精确计算，并返回BigDecimal类型。
         */
        Object minuendArg = args[0];
        Object stepArg = null;
        if (args.length == 2) {
            stepArg = args[1];
        }

        // 使用Integer计算
        if (minuendArg instanceof Integer && (stepArg == null || stepArg instanceof Integer)) {
            if (stepArg == null) {
                stepArg = 1;
            }
            return doSub(((Integer) minuendArg).intValue(), ((Integer) stepArg).intValue());
        }

        // 使用Long计算
        boolean minuendArgCanLong = (minuendArg instanceof Long || minuendArg instanceof Integer);
        boolean stepArgCanLong = (stepArg == null || stepArg instanceof Long || stepArg instanceof Integer);
        if (minuendArgCanLong && stepArgCanLong) {
            if (stepArg == null) {
                stepArg = 1L;
            }
            return doSub(((Number) minuendArg).longValue(), ((Number) stepArg).longValue());
        }


        // 默认使用BigDecimal计算
        if (stepArg == null) {
            stepArg = BigDecimal.ONE;
        }
        try {
             if (!(stepArg instanceof BigDecimal)) {
                stepArg = new BigDecimal(stepArg.toString());
            }
        } catch(Exception e) {
            throw new OqlExpResolvedException(stepArg + "参数无法转换为数值类型", e);
        }

        try {
            if (!(minuendArg instanceof BigDecimal)) {
                minuendArg = new BigDecimal(minuendArg.toString());
            }
        } catch(Exception e) {
            throw new OqlExpResolvedException(minuendArg + "参数无法转换为数值类型", e);
        }

        return doSub((BigDecimal)minuendArg, (BigDecimal)stepArg);
    }

    /**
     * 执行减法运算
     * @param minuend 减数
     * @param step 步长
     * @return 差
     */
    private int doSub(int minuend, int step) {
        return minuend - step;
    }

    /**
     * 执行减法运算
     * @param minuend 减数
     * @param step 步长
     * @return 差
     */
    private long doSub(long minuend, long step) {
        return minuend - step;
    }


    /**
     * 执行减法运算
     * @param minuend 减数
     * @param step 步长
     * @return 差
     */
    private BigDecimal doSub(BigDecimal minuend, BigDecimal step) {
        return minuend.subtract(step);
    }

    @Override
    protected int getMaxArgsSize() {
        return 2;
    }

    @Override
    public String getSupportedFunName() {
        return "Dncr";
    }
}
