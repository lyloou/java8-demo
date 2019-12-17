package com.example.algs.leetcode._015threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solution4 {
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution4().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 先决判断
        if (nums == null || nums.length < 3) {
            return lists;
        }
        // 排序
        Arrays.sort(nums);
        // i的范围: 从0到左右指针的左边
        for (int i = 0; i < nums.length - 2; i++) {
            // i去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 左指针
            int l = i + 1;
            // 右指针
            int r = nums.length - 1;
            // 指针比较
            while (l < r) {
                // 求和
                int tmp = nums[i] + nums[l] + nums[r];
                // 总和小于0，左指针前进
                if (tmp < 0) {
                    l++;
                    continue;
                }
                // 总和大于0，右指针后退
                if (tmp > 0) {
                    r--;
                    continue;
                }
                // 总和为0，符合条件，记录下来
                lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                // 左指针去重
                while (l < r && nums[l] == nums[l + 1]) {
                    l++;
                }
                // 右指针去重
                while (l < r && nums[r] == nums[r - 1]) {
                    r--;
                }
                // 左指针前进
                l++;
                // 右指针后退
                r--;
            }
        }

        return lists;
    }
}
