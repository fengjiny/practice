package algorithms.leetcode_20181226.tree;

public class LC701_Insert_into_a_Binary_Search_Tree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {
                if (cur.right != null){
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
