package com.example.algs.leetcode._015threeSum;

import java.util.*;

class Solution2 {
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution2().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort(Integer::compareTo);
        int len = list.size();

        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int k = getK(list.get(i) + list.get(j), j + 1, list);
                if (k > 0) {
                    s.add(Arrays.asList(list.get(i), list.get(j), list.get(k)));
                }
            }
        }

        return new ArrayList<>(s);
    }

    private int getK(int sum, int index, List<Integer> list) {
        if (index >= list.size()) {
            return -1;
        }
        for (int i = index; i < list.size(); i++) {
            if ((-1 * sum) == list.get(i)) {
                return i;
            }
        }
        return -1;
    }
}