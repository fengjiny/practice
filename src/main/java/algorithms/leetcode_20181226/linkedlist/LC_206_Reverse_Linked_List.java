package algorithms.leetcode_20181226.linkedlist;

public class LC_206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode reverseList(ListNode pre, ListNode head) {
        if (head == null)
            return pre;
        ListNode next = head.next;
        head.next = pre;
        return reverseList(head, next);
    }
}
