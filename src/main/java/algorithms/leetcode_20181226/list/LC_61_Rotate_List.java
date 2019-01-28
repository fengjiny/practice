package algorithms.leetcode_20181226.list;

public class LC_61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        dummy.next = head;
        int len = 0;
        while (fast.next != null) {
            ++len;
            fast = fast.next;
        }
        k %= len;

        fast = dummy;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
