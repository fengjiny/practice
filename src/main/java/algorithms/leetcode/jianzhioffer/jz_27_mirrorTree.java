package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

public class jz_27_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode l = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(l);
        return root;
    }
}
