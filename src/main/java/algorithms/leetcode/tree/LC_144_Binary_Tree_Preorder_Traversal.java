package algorithms.leetcode.tree;

import java.util.*;

public class LC_144_Binary_Tree_Preorder_Traversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }
    private void preOrder(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * iteratively
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            list.add(root.val);
            if (root.left != null) s.push(root.left);
            if (root.right != null) s.push(root.right);
        }
        return list;
    }
}
