package algorithms.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}


public class LC_116_Populating_Next_Right_Pointers_in_Each_Node {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeLinkNode prev = null;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeLinkNode cur = q.poll();
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
                cur.next = prev;
                prev = cur;
            }
        }
    }

    public void connect2(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre  = pre.left;
        }
    }
}
