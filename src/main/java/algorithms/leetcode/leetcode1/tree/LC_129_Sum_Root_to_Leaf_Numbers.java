package algorithms.leetcode.leetcode1.tree;

public class LC_129_Sum_Root_to_Leaf_Numbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        recurse(root, 0);
        return sum;
    }
    private void recurse(TreeNode root, int preSum) {
        if (root == null) return;
        preSum *= 10;
        if (root.left == null && root.right == null) {
            sum += preSum + root.val;
        }
        recurse(root.left, root.val + preSum);
        recurse(root.right, root.val + preSum);
    }

    private int sum(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        return sum(root.left, sum * 10 + root.val) + sum(root.right, sum * 10 + root.val);
    }
}
