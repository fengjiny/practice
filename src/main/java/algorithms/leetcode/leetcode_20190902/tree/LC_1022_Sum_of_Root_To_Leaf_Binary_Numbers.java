package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

public class LC_1022_Sum_of_Root_To_Leaf_Binary_Numbers {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = 2 * val + root.val;
        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }
}
