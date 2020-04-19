package com.example.algs.leetcode._020isValid;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author lyloou
 * @date 2019/12/23
 */
public class Solutions {

    public static void main(String[] args) {
        System.out.println(new Solutions().isValid("[](){}"));
    }

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        String[] str = s.split("");
        Stack<String> stack = new Stack<>();
        for (String item : str) {

            // 如果是左括号，入栈
            if (leftBrackets.contains(item)) {
                stack.push(item);
                continue;
            }

            // 如果是右括号，出栈并验证
            if (rightBrackets.contains(item)) {
                if (stack.isEmpty()) {
                    return false;
                }
                String match = stack.pop();
                if (!checkIsMatch(item, match)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean checkIsMatch(String item, String match) {
        switch (item) {
            case "}":
                return "{".equals(match);
            case "]":
                return "[".equals(match);
            case ")":
                return "(".equals(match);
        }
        return false;
    }

    private static final List<String> rightBrackets = Arrays.asList("}", "]", ")");


    private static final List<String> leftBrackets = Arrays.asList("{", "[", "(");

}
