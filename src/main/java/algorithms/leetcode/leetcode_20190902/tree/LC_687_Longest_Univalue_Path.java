package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

public class LC_687_Longest_Univalue_Path {
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) dfs(root, res);
        return res[0];
    }
    private int dfs(TreeNode root, int[] res) {
        int l = root.left != null ? dfs(root.left, res) : 0;
        int r = root.right != null ? dfs(root.right, res) : 0;
        int resl = root.left != null && root.left.val == root.val ? l + 1 : 0;
        int resr = root.right != null && root.right.val == root.val ? r + 1 : 0;
        res[0] = Math.max(res[0], resl + resr);
        return Math.max(resl, resr);
    }
}
