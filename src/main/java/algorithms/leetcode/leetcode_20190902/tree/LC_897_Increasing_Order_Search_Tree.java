package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

import java.util.Stack;

public class LC_897_Increasing_Order_Search_Tree {

    Stack<Integer> stack = new Stack<>();
    TreeNode pre = null, head = null;
    public TreeNode increasingBST(TreeNode root) {
//        if (root == null) return root;
//        inorder(root);
//        return create(stack);
        if (root == null) return root;
        increasingBST(root.left);
        if (pre != null) {
            root.left = null;
            pre.right = root;
        }
        if (head == null) head = root;
        pre = root;
        increasingBST(root.right);
        return head;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        stack.push(root.val);
        inorder(root.left);
    }
    private TreeNode create(Stack<Integer> stack) {
        if (stack.isEmpty()) return null;
        TreeNode node = new TreeNode(stack.pop());
        node.right = create(stack);
        return node;
    }
}
