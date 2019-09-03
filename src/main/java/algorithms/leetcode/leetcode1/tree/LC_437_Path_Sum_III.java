package algorithms.leetcode.leetcode1.tree;

public class LC_437_Path_Sum_III {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum);
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null)return 0;
        return (root.val == sum ? 1 : 0) +
                helper(root.left, sum - root.val) +
                helper(root.right, sum - root.val);
    }

}
