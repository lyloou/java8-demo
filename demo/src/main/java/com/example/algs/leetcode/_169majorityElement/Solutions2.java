package com.example.algs.leetcode._169majorityElement;

import java.util.Arrays;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solutions2 {
    public static void main(String[] args) {
        int i = new Solutions2().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
