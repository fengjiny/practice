package algorithms.leetcode.leetcode_20181226.tree;

public class LC_226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
