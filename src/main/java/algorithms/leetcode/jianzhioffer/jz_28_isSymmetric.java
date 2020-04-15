package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

public class jz_28_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null) return false;
        if (r == null) return false;
        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
}
