package algorithms.leetcode.jianzhioffer;

import java.util.Stack;

public class jz_31_validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int n = popped.length;
        int j = 0;
        for (int i = 0; i < pushed.length; ++i) {
            s.push(pushed[i]);
            while (!s.isEmpty() && j < n && s.peek() == popped[j]) {
                s.pop();
                ++j;
            }
        }
        return s.isEmpty();
    }
}
