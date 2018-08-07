package algorithms.leetcode.list;

public class LC_24_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n = head.next;
        n.next = head;
        head.next = swapPairs(head.next.next);
        return n;
    }
}
