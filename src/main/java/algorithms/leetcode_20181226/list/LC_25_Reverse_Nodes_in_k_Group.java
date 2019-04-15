package algorithms.leetcode_20181226.list;

import java.util.List;

public class LC_25_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            ++count;
        }
        while (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }
}
