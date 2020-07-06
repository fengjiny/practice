package algorithms.leetcode.lc_20200609.list;

public class LC_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy.next;
        for (int i = 1; i < m; ++i) {
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = m; i < n; ++i) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
