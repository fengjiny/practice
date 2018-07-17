package algorithms.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC_513_Find_Bottom_Left_Tree_Value {
    public static int findBottomLeftValue(TreeNode root) {
        return findLeftBottomNode(root).val;
    }
    private static TreeNode findLeftBottomNode(TreeNode root) {
        if (root == null) return root;
        TreeNode res = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ;i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
                res = node;
            }
        }
        return res;
    }

    private int solution(TreeNode root) {
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
