package com.example.algs.leetcode._041firstMissingPositive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solutions {
    public static void main(String[] args) {
        System.out.println(new Solutions().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solutions().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new Solutions().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length < 1) {
            return 1;
        }
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int maxNum = nums[nums.length - 1];
        for (int i = 1; i <= maxNum; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return maxNum + 1 <= 0 ? 1 : maxNum + 1;
    }


}
