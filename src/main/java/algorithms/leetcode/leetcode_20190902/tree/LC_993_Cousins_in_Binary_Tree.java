package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_993_Cousins_in_Binary_Tree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isXexist = false;
            boolean isYexist = false;
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                if (root.val == x) isXexist = true;
                if (root.val == y) isYexist = true;
                if (root.left != null && root.right != null) {
                    if (root.left.val == x && root.right.val == y) return false;
                    if (root.left.val == y && root.right.val == x) return false;
                }
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            if (isXexist && isYexist) return true;
        }
        return true;
    }
}
