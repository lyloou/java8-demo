package com.example.algs.leetcode._041firstMissingPositive;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solutions4 {
    public static void main(String[] args) {
        System.out.println(new Solutions4().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solutions4().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new Solutions4().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i] - 1]) {
                swap2(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void swap2(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
