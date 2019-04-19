package algorithms.leetcode_20181226.tree;

public class LC_99_Recover_Binary_Search_Tree {

    TreeNode firstElement = null, secondElement = null, preELement = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        traverse(root);
        int tmp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (preELement != null) {
            if (firstElement == null && preELement.val >= root.val) {
                firstElement = preELement;
            }
            if (firstElement != null && preELement.val >= root.val) {
                secondElement = root;
            }
        }
        preELement = root;
        traverse(root.right);
    }
}
