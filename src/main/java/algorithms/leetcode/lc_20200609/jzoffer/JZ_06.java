package algorithms.leetcode.lc_20200609.jzoffer;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class JZ_06 {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode pre = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            ++size;
        }

        int[] res = new int[size];
        for (int i = 0; i < size; ++i) {
            res[i] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
