package com.example.algs.leetcode._015threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [三数之和 - 提交记录 - 力扣 (LeetCode)](https://leetcode-cn.com/submissions/detail/40171946/)
 * 夹逼方案
 */

class Solution3 {
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution3().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 先决判断
        if (nums == null) {
            return new ArrayList<>();
        }
        int len = nums.length;
        if (len < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();

        // 排序
        Arrays.sort(nums);
        // i的范围: 从0到左右指针的左边
        for (int i = 0; i < len - 2; i++) {
            // i去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 左指针
            int l = i + 1;
            // 右指针
            int r = len - 1;

            // 指针比较
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                // 总和小于0，左指针前进
                if (tmp < 0) {
                    l += 1;
                    continue;
                }
                // 总和大于0，右指针后退
                if (tmp > 0) {
                    r -= 1;
                    continue;
                }

                // 总和为0，符合条件，记录下来
                lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                // 左指针去重
                while (l < r && nums[l] == nums[l + 1]) {
                    l += 1;
                }
                // 右指针去重
                while (l < r && nums[r] == nums[r - 1]) {
                    r -= 1;
                }
                // 左指针前进
                l += 1;
                // 右指针后退
                r -= 1;
            }
        }
        return lists;
    }

}