package algorithms.leetcode.leetcode1.tree;

public class LC_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > q.val ? root.left : root.right;
        }
        return root;
    }
}
