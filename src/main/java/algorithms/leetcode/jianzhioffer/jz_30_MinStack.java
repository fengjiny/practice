package algorithms.leetcode.jianzhioffer;

import java.util.Stack;

public class jz_30_MinStack {
    Stack<Integer> s1, s2;

    public jz_30_MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x) {
            s2.push(x);
        }
    }

    public void pop() {
        if (s1.pop().equals(s2.peek())) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
