package algorithms.leetcode.lc_20200609.jzoffer;

import java.util.Stack;

public class JZ_09_CQueue {
    Stack<Integer> sPush, sPop;
    public JZ_09_CQueue() {
        sPush = new Stack<>();
        sPop = new Stack<>();
    }

    public void appendTail(int value) {
        sPush.push(value);
    }

    public int deleteHead() {
        if (sPop.isEmpty()) {
            while(!sPush.isEmpty()) {
                sPop.push(sPush.pop());
            }
        }
        return sPop.isEmpty() ? -1 : sPop.pop();
    }
}
