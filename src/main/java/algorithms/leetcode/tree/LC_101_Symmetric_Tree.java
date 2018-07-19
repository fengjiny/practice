package algorithms.leetcode.tree;

public class LC_101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode r, TreeNode t) {
        if (r == null || t == null) return r == t;
        return (r.val == t.val) && isSame(r.left, t.right) && isSame(r.right, t.left);
    }
}
