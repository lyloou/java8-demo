package com.example.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author lyloou
 */
public class Ucalc {

    /**
     * 比较两个数值是否相等
     */
    public static boolean isEqual(Object x, Object y) {
        return compareTo(x, y) == 0;
    }

    /**
     * 判断数值是否等于0
     */
    public static boolean isEqualZero(Object x) {
        return BigDecimal.ZERO.compareTo(new BigDecimal("" + x)) == 0;
    }

    /**
     * 比较数字大小，x > y返回-1，x = y返回0，x < y返回1
     */
    public static int compareTo(Object x, Object y) {
        return new BigDecimal(x + "").compareTo(new BigDecimal(y + ""));
    }

    /**
     * 加法
     */
    public static BigDecimal add(Object x, Object y) {
        return new BigDecimal(x + "").add(new BigDecimal(y + ""));
    }

    /**
     * 加法并格式化为2位
     */
    public static BigDecimal addFormat(Object x, Object y) {
        return new BigDecimal(x + "").add(new BigDecimal(y + "")).setScale(2, RoundingMode.FLOOR);
    }

    /**
     * 减法
     */
    public static BigDecimal subtract(Object x, Object y) {
        return new BigDecimal(x + "").subtract(new BigDecimal(y + ""));
    }

    /**
     * 减法并格式化为2位
     */
    public static BigDecimal subtractFormat(Object x, Object y) {
        return new BigDecimal(x + "").subtract(new BigDecimal(y + "")).setScale(2, RoundingMode.FLOOR);
    }

    /**
     * 乘法
     */
    public static BigDecimal multiply(Object x, Object y) {
        return new BigDecimal(x + "").multiply(new BigDecimal(y + ""));
    }

    /**
     * 多数相乘
     */
    public static BigDecimal multiply(Object... x) {
        BigDecimal result = BigDecimal.ONE;
        for (Object _x : x) {
            result = result.multiply(new BigDecimal(_x + ""));
        }
        return result;
    }

    /**
     * 乘法并格式化为2位数
     */
    public static BigDecimal multiplyFormat(Object x, Object y, int bit) {
        return new BigDecimal(x + "").multiply(new BigDecimal(y + "")).setScale(bit, RoundingMode.FLOOR);
    }

    /**
     * 除法
     */
    public static BigDecimal divide(Object x, Object y, int bit) {
        return new BigDecimal(x + "").divide(new BigDecimal(y + ""), bit, RoundingMode.FLOOR);
    }

    /**
     * 除法
     */
    public static BigDecimal divide(Object x, Object y, int bit, RoundingMode mode) {
        return new BigDecimal(x + "").divide(new BigDecimal(y + ""), bit, mode);
    }

    /**
     * 格式化金额
     */
    public static Double formatMoney(Object x) {
        return new BigDecimal(x.toString()).setScale(2, RoundingMode.FLOOR).doubleValue();
    }

    /**
     * 格式化为BD
     */
    public static BigDecimal formatBig(Object x) {
        return new BigDecimal(x.toString()).setScale(2, RoundingMode.FLOOR);
    }


    public static BigDecimal setScale(Object x, int scale, RoundingMode mode) {
        return new BigDecimal(x + "").setScale(scale, mode);
    }

    /**
     * 取多者中最小者
     */
    public static BigDecimal min(Object... x) {
        BigDecimal result = new BigDecimal(x[0] + "");
        for (Object _x : x) {
            result = result.compareTo(new BigDecimal(_x + "")) > 0 ? new BigDecimal(_x + "") : result;
        }
        return result;
    }

    /**
     * 取多者中最大者
     */
    public static BigDecimal max(Object... x) {
        BigDecimal result = new BigDecimal(x[0] + "");
        for (Object _x : x) {
            result = result.compareTo(new BigDecimal(_x + "")) < 0 ? new BigDecimal(_x + "") : result;
        }
        return result;
    }

}
