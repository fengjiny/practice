package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

public class LC_783_Minimum_Distance_Between_BST_Nodes {
    int min = Integer.MAX_VALUE;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return min;
        minDiffInBST(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        minDiffInBST(root.right);
        return min;
    }
}
