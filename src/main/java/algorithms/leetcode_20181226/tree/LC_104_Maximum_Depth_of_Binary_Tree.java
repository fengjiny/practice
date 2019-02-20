package algorithms.leetcode_20181226.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC_104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return 1 + Math.max(left, right);
    }

    public int maxDepth_BFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            ++count;
        }
        return count;
    }
}
