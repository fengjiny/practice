package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

import java.util.*;

public class jz_32_levelOrder_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                root = q.poll();
                tmp.add(root.val);
                if (root.left != null) q.offer(root.left);
                if (root.right != null) q.offer(root.right);
            }
            if (level%2 == 0) {
                Collections.reverse(tmp);
            }
            res.add(tmp);
            ++level;
        }
        return res;
    }
}
