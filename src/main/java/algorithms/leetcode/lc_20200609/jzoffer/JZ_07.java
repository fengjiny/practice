package algorithms.leetcode.lc_20200609.jzoffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class JZ_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preoder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preoder.length - 1 || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preoder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == node.val) {
                index = i;
            }
        }
        node.left = buildTree(preoder, inorder, preStart + 1, inStart, index - 1);
        node.right = buildTree(preoder, inorder, preStart + index - inStart + 1, index + 1, inEnd);
        return node;
    }
}
