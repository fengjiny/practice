package algorithms.leetcode.leetcode1.tree;

public class LC_230_Kth_Smallest_Element_in_a_BST {

    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
