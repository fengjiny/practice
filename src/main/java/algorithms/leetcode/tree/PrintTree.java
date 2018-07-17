package algorithms.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
    public static void printTree(TreeNode head) {
        Queue<TreeNode> q = new LinkedList<>();
        if (head != null) q.offer(head);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                System.out.print(node.val + " ");
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.println();
        }
    }
}
