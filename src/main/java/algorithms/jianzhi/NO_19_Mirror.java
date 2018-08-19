package algorithms.jianzhi;

public class NO_19_Mirror {
    public void Mirror(TreeNode root) {
        invert(root);
    }
    private TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = invert(root.right);
        root.right = invert(left);
        return root;
    }
}
