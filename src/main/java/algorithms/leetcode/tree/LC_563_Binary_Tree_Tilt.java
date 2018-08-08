package algorithms.leetcode.tree;

public class LC_563_Binary_Tree_Tilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return tilt;
    }
    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
