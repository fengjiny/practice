package algorithms.leetcode.list;

public class LC_82_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
