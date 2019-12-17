package com.example.algs.leetcode._015threeSum;

import java.util.*;

class Solution1 {
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution1().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = getK(nums[i] + nums[j], j + 1, nums);
                if (k > 0) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }

        return new ArrayList<>(s);
    }

    private int getK(int sum, int index, int[] nums) {
        if (index >= nums.length) {
            return -1;
        }
        for (int i = index; i < nums.length; i++) {
            if ((-1 * sum) == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}