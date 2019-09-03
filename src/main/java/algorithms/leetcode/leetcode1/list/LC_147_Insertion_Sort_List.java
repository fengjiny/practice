package algorithms.leetcode.leetcode1.list;

public class LC_147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        ListNode pre = newHead;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = newHead;
            cur = next;
        }
        return newHead.next;

    }
}
