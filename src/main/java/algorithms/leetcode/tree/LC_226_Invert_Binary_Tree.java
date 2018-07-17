package algorithms.leetcode.tree;

import java.util.Stack;

public class LC_226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return root;
    }
}
