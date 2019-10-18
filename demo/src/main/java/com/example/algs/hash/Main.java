package com.example.algs.hash;


/**
 * @author lyloou
 * @date 2019/08/28
 */
public class Main {
    private static final int MAXIMUM_CAPACITY = 2147483647;

    public static void main(String[] args) {
        System.out.println(Double.isNaN(Double.NaN));
        System.out.println(Float.isNaN(Float.NaN));
        System.out.println(tableSizeFor(232444333));
        System.out.println(Math.sqrt(268435456));
        System.out.println(Math.log(268435456) / Math.log(2));
        System.out.println(Math.pow(2, 28));
    }

    /**
     * 自动补齐
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
