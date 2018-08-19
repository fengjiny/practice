package algorithms.jianzhi;

public class NO_6_ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return construct(0, 0, in.length - 1, pre, in);
    }
    private TreeNode construct(int preStart,int inStart, int inEnd,
                               int[] pre, int[] in) {
        if (preStart > pre.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; ++i) {
            if (in[i] == root.val) {
                index = i;
            }
        }
        root.left = construct(preStart + 1, inStart,index - 1, pre, in);
        root.right = construct(preStart + index - inStart + 1, index + 1, inEnd, pre, in);
        return root;
    }
}
