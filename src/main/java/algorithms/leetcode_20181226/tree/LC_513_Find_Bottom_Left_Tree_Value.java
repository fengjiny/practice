package algorithms.leetcode_20181226.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC_513_Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }
}
