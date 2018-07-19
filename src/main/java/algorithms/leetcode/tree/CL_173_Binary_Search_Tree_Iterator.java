package algorithms.leetcode.tree;

import java.util.Stack;

public class CL_173_Binary_Search_Tree_Iterator {
    private Stack<TreeNode> stack = new Stack<>();

    public CL_173_Binary_Search_Tree_Iterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
