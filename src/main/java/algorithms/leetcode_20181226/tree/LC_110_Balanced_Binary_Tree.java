package algorithms.leetcode_20181226.tree;

public class LC_110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = depth(root.left);
        int r = depth(root.right);
        return Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public boolean isBalanced_dfs(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;
        int l = dfsHeight(root.left);
        if (l == -1) return -1;
        int r = dfsHeight(root.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
