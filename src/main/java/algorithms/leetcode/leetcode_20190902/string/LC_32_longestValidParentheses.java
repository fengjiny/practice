package algorithms.leetcode.leetcode_20190902.string;

import java.util.Stack;

public class LC_32_longestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.isEmpty()) {
            longest = n;
        } else {
            int a = 0, b = n;
            while (!stack.isEmpty()) {
                a = stack.pop();
                longest = Math.max(longest, b - a - 1);
                b = a;
            }
            longest = Math.max(longest, b);
        }
        return longest;
    }
}
