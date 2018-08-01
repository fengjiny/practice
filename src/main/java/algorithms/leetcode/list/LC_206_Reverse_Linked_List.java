package algorithms.leetcode.list;

public class LC_206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return head;
    }

    public ListNode reverseList_recursive(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList_recursive(next, head);

    }
}