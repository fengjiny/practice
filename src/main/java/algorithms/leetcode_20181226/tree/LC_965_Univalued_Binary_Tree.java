package algorithms.leetcode_20181226.tree;

public class LC_965_Univalued_Binary_Tree {
    public boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (!isUnivalTree(root.left)) {
                return false;
            }
            if (root.left.val != root.val) {
                return false;
            }
        }

        if (root.right != null) {
            if (!isUnivalTree(root.right)) {
                return false;
            }
            if (root.right.val != root.val) {
                return false;
            }
        }
        return true;
    }

}
