package com.example.algs.leetcode._041firstMissingPositive;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solutions2 {
    public static void main(String[] args) {
        System.out.println(new Solutions2().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solutions2().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new Solutions2().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    // 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
    // 然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，
    // 否则遍历完都没出现那么答案就是数组长度加1。
    // 如：[1,2,3,4,5,6,7]
    // 对应[1,2,4,5,6]，那么就知道了是3
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        Integer[] integers = set.toArray(new Integer[0]);
        for (int i = 0; i < integers.length; i++) {
            if (i + 1 != integers[i]) {
                return i + 1;
            }
        }
        return integers.length + 1;
    }


}
