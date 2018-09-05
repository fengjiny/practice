package algorithms.jianzhi;

public class NO_39_TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
