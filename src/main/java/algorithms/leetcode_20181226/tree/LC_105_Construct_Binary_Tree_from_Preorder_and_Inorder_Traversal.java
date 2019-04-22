package algorithms.leetcode_20181226.tree;

public class LC_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    private TreeNode helper(int preBegin, int inBegin, int inEnd, int[] preOrder, int[] inOrder) {
        if (preBegin > preOrder.length - 1 || inBegin > inEnd) return null;
        TreeNode node  = new TreeNode(preOrder[preBegin]);
        int index = 0;
        for (int i = inBegin; i <= inEnd; ++i) {
            if (inOrder[i] == node.val) {
                index = i;
            }
        }
        node.left = helper(preBegin + 1, inBegin, index - 1, preOrder, inOrder);
        node.right = helper(preBegin + index - inBegin + 1, index + 1, inEnd, preOrder, inOrder);
        return node;
    }
}
