package algorithms.leetcode_20181226.tree;

public class LC_700_Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val){
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
