package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.FunHandlerContext;

import java.math.BigDecimal;

/**
 *  Incr函数处理器，用于对arg1参数进行累加，累加步长为arg2。
 *  ps：
 *      1、如果arg2参数为null，则默认步长为1。
 *
 * 例如： ${Incr(arg1, arg2)}。
 * @author gwj
 */
public class IncrFunHandler extends AbstractFunHandler {

    @Override
    public Object handleActually(FunHandlerContext context) {
        Object[] args = context.getArgs();
        /**
         * 做优化处理：
         *  1、如果加数和步长都是Integer类型，则直接用Integer来计算，并返回Integer类型。
         *  2、如果加数和步长都为Long类型或者包含Integer类型，则直接用Long来计算，并返回Long类型。
         *  3、如果并不是Integer或者Long类型，则默认使用BigDecimal类型来精确计算，并返回BigDecimal类型。
         */
        Object addendArg = args[0];
        Object stepArg = null;
        if (args.length == 2) {
            stepArg = args[1];
        }

        // 使用Integer计算
        if (addendArg instanceof Integer && (stepArg == null || stepArg instanceof Integer)) {
            if (stepArg == null) {
                stepArg = 1;
            }
            return doAdd(((Integer) addendArg).intValue(), ((Integer) stepArg).intValue());
        }

        // 使用Long计算
        boolean addendArgCanLong = (addendArg instanceof Long || addendArg instanceof Integer);
        boolean stepArgCanLong = (stepArg == null || stepArg instanceof Long || stepArg instanceof Integer);
        if (addendArgCanLong && stepArgCanLong) {
            if (stepArg == null) {
                stepArg = 1L;
            }
            return doAdd(((Number) addendArg).longValue(), ((Number) stepArg).longValue());
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
            if (!(addendArg instanceof BigDecimal)) {
                addendArg = new BigDecimal(addendArg.toString());
            }
        } catch(Exception e) {
            throw new OqlExpResolvedException(addendArg + "参数无法转换为数值类型", e);
        }

        return doAdd((BigDecimal)addendArg, (BigDecimal)stepArg);
    }

    /**
     * 执行加法运算
     * @param addend 加数
     * @param step 步长
     * @return 和
     */
    private int doAdd(int addend, int step) {
        return addend + step;
    }

    /**
     * 执行加法运算
     * @param addend 加数
     * @param step 步长
     * @return 和
     */
    private long doAdd(long addend, long step) {
        return addend + step;
    }


    /**
     * 执行加法运算
     * @param addend 加数
     * @param step 步长
     * @return 和
     */
    private BigDecimal doAdd(BigDecimal addend, BigDecimal step) {
        return addend.add(step);
    }

    @Override
    protected int getMaxArgsSize() {
        return 2;
    }

    @Override
    public String getSupportedFunName() {
        return "Incr";
    }
}
