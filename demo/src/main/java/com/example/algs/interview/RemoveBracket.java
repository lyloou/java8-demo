package com.example.algs.interview;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 2:
 * 输入: "([)]"
 * 输出: false
 */
public class RemoveBracket {
    public static void main(String[] args) {
        String s = "{{[]}}()";
        s = handleStr(s);
        System.out.println(s);
        System.out.println(s.length() == 0);
    }

    private static String handleStr(String s) {
        int length = s.length();
        for (int i = 0; i < length && !s.isEmpty(); i++) {
            s = s.replaceAll("\\{\\}", "");
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\[\\]", "");
        }
        return s;
    }
}
