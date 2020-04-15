package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class jz_32_levelOrder_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0 ; i < n; ++i) {
                root = q.poll();
                tmp.add(root.val);
                if (root.left != null) q.offer(root.left);
                if (root.right != null) q.offer(root.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
