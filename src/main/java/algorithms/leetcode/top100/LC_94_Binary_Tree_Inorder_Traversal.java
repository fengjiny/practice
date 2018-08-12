package algorithms.leetcode.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.empty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            list.add(cur.val);
            cur  = cur.right;
        }
        return list;
    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal_recurse(TreeNode root) {
        recurse(root);
        return res;
    }
    private void recurse(TreeNode root) {
        if (root == null) return;;
        recurse(root.left);
        res.add(root.val);
        recurse(root.right);
    }
}
