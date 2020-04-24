package com.example.algs.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class SubStr {

    public static void main(String[] args) {
        String s = "abcdabcdefggc";
        System.out.println(countMaxLongSubStr(s));
    }

    private static int countMaxLongSubStr(String s) {
        int maxCount = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
            }
            if (maxCount < set.size()) {
                maxCount = set.size();
            }
        }
        return maxCount;
    }
}
