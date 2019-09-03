package algorithms.leetcode.leetcode_20181226.tree;

public class LC_114_Flatten_Binary_Tree_to_Linked_List {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
