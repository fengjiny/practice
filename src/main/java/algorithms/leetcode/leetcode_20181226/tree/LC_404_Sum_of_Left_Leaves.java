package algorithms.leetcode.leetcode_20181226.tree;


import java.util.Stack;

public class LC_404_Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftLeaves_itr(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null)
                    sum += root.left.val;
                else
                    stack.push(root.left);
            }
            if (root.right != null) {
                if (root.right.left != null || root.right.right != null)
                    stack.push(root.right);
            }
        }
        return sum;
    }
}
