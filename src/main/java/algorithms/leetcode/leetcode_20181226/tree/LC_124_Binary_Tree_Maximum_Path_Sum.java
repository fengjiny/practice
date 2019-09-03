package algorithms.leetcode.leetcode_20181226.tree;

public class LC_124_Binary_Tree_Maximum_Path_Sum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));
        max = Math.max(max, l + r + root.val);
        return Math.max(l, r) + root.val;
    }

}
