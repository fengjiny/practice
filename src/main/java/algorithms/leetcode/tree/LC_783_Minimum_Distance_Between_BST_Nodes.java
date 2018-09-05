package algorithms.leetcode.tree;

public class LC_783_Minimum_Distance_Between_BST_Nodes {
    Integer res, pre;
    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = null;
        inOrder(root);
        return res;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        inOrder(root.right);
    }
}
