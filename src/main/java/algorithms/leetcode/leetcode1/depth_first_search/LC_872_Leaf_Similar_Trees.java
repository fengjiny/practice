package algorithms.leetcode.leetcode1.depth_first_search;


public class LC_872_Leaf_Similar_Trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return traverse(root1).equals(traverse(root2));
    }
    private String traverse(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "-";
        return traverse(root.left) + traverse(root.right);
    }
}
