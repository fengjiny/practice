package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

import java.util.Stack;

public class LC_872_Leaf_Similar_Trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2= new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (dfs(stack1) != dfs(stack2)) return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();

    }
    public int dfs(Stack<TreeNode> stack) {
        while (true) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }
}
