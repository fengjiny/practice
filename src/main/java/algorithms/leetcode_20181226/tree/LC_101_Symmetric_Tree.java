package algorithms.leetcode_20181226.tree;

public class LC_101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSame(root.left, root.right);
    }
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSame(p.left, q.right) && isSame(p.right, q.left);
    }
}
