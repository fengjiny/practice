package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class jz_34_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        pathSum(res, cur, root, sum);
        return res;
    }

    private void pathSum(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum) {
        if (root == null) return;
        cur.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new LinkedList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        } else {
            pathSum(res, cur, root.left, sum - root.val);
            pathSum(res, cur, root.right, sum - root.val);
        }
        cur.remove(cur.size() - 1);
    }
}
