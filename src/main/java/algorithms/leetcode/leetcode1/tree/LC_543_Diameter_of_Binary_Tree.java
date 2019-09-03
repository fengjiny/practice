package algorithms.leetcode.leetcode1.tree;

public class LC_543_Diameter_of_Binary_Tree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return diameter;
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left , right);
    }
}
