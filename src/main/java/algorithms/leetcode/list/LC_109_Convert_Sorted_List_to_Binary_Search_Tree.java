package algorithms.leetcode.list;


public class LC_109_Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head,null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);
        return node;
    }
}
