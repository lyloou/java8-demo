package com.example.algs.leetcode._041firstMissingPositive;

import java.util.Arrays;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solutions3 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 0};
        Arrays.sort(ints);
        System.out.println(new Solutions3().binarySearch(ints, 3));
        System.out.println(new Solutions3().binarySearch(ints, 1));
        System.out.println(new Solutions3().binarySearch(ints, 2));
        System.out.println(new Solutions3().binarySearch(ints, 0));
        System.out.println(new Solutions3().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solutions3().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new Solutions3().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        Arrays.sort(nums);
        int maxNum = nums[nums.length - 1];
        for (int i = 1; i < maxNum; i++) {
            if (!(binarySearch(nums, i) > -1)) {
                return i;
            }
        }
        return Math.max(maxNum + 1, 1);
    }

    private int binarySearch(int[] nums, int i) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r && (mid = (l + r) / 2) >= 0) {
            if (nums[mid] > i) {
                r = mid - 1;
            } else if (nums[mid] < i) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
