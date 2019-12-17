package com.example.algs.leetcode._169majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solutions {
    public static void main(String[] args) {
        int i = new Solutions().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int result = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > max) {
                max = count;
                result = num;
            }
            map.put(num, count);
        }
        return result;
    }
}
