package com.example.algs.leetcode._020isValid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author lyloou
 * @date 2019/12/23
 */
public class Solutions2 {

    public static void main(String[] args) {
        System.out.println(new Solutions2().isValid("[](){}"));
    }

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        String[] str = s.split("");
        Stack<String> stack = new Stack<>();
        for (String right : str) {
            // 如果是左括号，入栈
            if (isLeftBrackets(right)) {
                stack.push(right);
                continue;
            }

            // 如果是右括号，出栈并验证
            if (isRightBrackets(right)) {
                if (stack.isEmpty()) {
                    return false;
                }
                String left = stack.pop();
                if (!checkIsMatch(left, right)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static final Map<String, String> brackets = new HashMap<String, String>() {{
        put("{", "}");
        put("[", "]");
        put("(", ")");
    }};

    private boolean checkIsMatch(String left, String right) {
        return brackets.get(left).equals(right);
    }


    private boolean isRightBrackets(String item) {
        return brackets.containsValue(item);
    }


    private boolean isLeftBrackets(String item) {
        return brackets.containsKey(item);
    }

}
