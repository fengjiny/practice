package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

public class jz_07_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0,  0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == node.val) {
                index = i;
            }
        }
        node.left = buildTree(preorder, inorder, preStart + 1, inStart, index - 1);
        node.right = buildTree(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd);
        return node;
    }
}
