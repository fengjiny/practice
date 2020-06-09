package algorithms.leetcode.jianzhioffer;

import algorithms.ListNode;

import java.util.Stack;

public class jz_06_reversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head != null) {
            s.push(head.val);
            head = head.next;
        }
        int[] res = new int[s.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = s.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode  head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(new jz_06_reversePrint().reversePrint(head));
    }
}
