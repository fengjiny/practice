package algorithms.leetcode.leetcode1.list;

public class LC_61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int i = 0;
        while (fast.next != null) {
            ++i;
            fast = fast.next;
        }
        k = k % i;
        for (int j = i - k; j > 0; --j) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
