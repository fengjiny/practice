package algorithms.leetcode.leetcode1.depth_first_search;

public class LC_897_Increasing_Order_Search_Tree {
    TreeNode pre = null, head = null;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        if (pre != null) {
            root.left = null;
            pre.right = root;
        }
        if (head == null) head = root;
        pre = root;
        increasingBST(root.right);
        return head;
    }
}
