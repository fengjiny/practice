package algorithms.leetcode.leetcode_20181226.tree;

public class LC_687_Longest_Univalue_Path {
    int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return len;
    }
    private int dfs(TreeNode root, int pre) {
        if (root == null) return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        len = Math.max(len, left + right);
        if (root.val == pre) return Math.max(left, right) + 1;
        return 0;
    }
}
