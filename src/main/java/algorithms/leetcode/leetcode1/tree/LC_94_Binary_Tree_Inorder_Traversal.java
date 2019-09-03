package algorithms.leetcode.leetcode1.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_94_Binary_Tree_Inorder_Traversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recurse(root);
        return res;
    }

    private void recurse(TreeNode root) {
        if (root == null) return;
        recurse(root.left);
        res.add(root.val);
        recurse(root.right);
    }

    private List<Integer> inorderTraversal_iteratively(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur!= null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
