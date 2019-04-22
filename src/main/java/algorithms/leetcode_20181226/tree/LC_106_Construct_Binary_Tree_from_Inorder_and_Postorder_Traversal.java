package algorithms.leetcode_20181226.tree;

public class LC_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }
    private TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart > postEnd) return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i < inEnd; ++i) {
            if (inorder[i] == node.val) {
                index = i;
            }
        }
        node.left = helper(postStart, postStart + index - inStart - 1, inStart, index - 1, postorder, inorder);
        node.right = helper(postEnd - inEnd + index, postEnd - 1, index + 1, inEnd, postorder, inorder);
        return node;
    }
}
