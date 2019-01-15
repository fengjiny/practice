package algorithms.leetcode_20181226.linkedlist;

public class LC_203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode removeElements_recurse(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements_recurse(head.next, val);
        return head.val == val ? head.next : head;
    }
}
