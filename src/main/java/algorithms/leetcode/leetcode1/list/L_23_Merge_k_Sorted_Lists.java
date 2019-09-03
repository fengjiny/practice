package algorithms.leetcode.leetcode1.list;

public class L_23_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }
    public ListNode partition(ListNode[] list, int s, int e) {
        if (s == e) return list[s];
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partition(list, s, q);
            ListNode l2 = partition(list, q + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
}
