package algorithms.leetcode.lc_20200609.array;

import algorithms.leetcode.TreeNode;

public class LC_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == node.val) {
                index = i;
            }
        }
        node.left = buildTree(inorder, postorder, postEnd - inEnd + index - 1, inStart, index - 1);
        node.right = buildTree(inorder, postorder, postEnd - 1, index + 1, inEnd);
        return node;
    }
}
