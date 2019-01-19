package algorithms.leetcode_20181226.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_23_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists_2(ListNode[] lists) {
        return partition(lists, 0, lists.length);
    }

    private ListNode partition(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i];
        if (i < j) {
            int m = (i + j) / 2;
            ListNode l1 = partition(lists, i, m);
            ListNode l2 = partition(lists, m + 1, j);
            return merge(l1, l2);
        } else
            return null;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
