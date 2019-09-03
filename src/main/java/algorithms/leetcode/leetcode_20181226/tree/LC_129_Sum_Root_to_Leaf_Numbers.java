package algorithms.leetcode.leetcode_20181226.tree;

public class LC_129_Sum_Root_to_Leaf_Numbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int pre) {
        if (root.left == null && root.right == null) sum += pre * 10 + root.val;
        if (root.left != null) helper(root.left, pre * 10 + root.val);
        if (root.right != null) helper(root.right, pre * 10 + root.val);
    }
}
