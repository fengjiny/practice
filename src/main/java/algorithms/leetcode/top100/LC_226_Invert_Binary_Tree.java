package algorithms.leetcode.top100;

import java.util.Stack;

public class LC_226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree_iter(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode node = s.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) s.push(node.left);
            if (node.right != null) s.push(node.right);
        }
        return root;
    }
}
