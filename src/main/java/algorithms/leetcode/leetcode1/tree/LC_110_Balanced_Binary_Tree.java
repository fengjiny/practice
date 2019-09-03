package algorithms.leetcode.leetcode1.tree;

import static java.lang.Math.abs;

public class LC_110_Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return  (abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public boolean isBalanced2(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        if (abs(leftHeight- rightHeight) > 1) return  -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
