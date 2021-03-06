package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

public class LC_814_Binary_Tree_Pruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
