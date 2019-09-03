package algorithms.leetcode.leetcode1.tree;

import java.util.Stack;

public class LC_173_Binary_Search_Tree_Iterator {
    private Stack<TreeNode> stack = new Stack<>();

    public LC_173_Binary_Search_Tree_Iterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have Main next smallest number */
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
