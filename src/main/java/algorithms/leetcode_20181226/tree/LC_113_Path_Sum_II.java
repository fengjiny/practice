package algorithms.leetcode_20181226.tree;

import java.util.LinkedList;
import java.util.List;

public class LC_113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curRes = new LinkedList<>();
        pathSum(root, sum, curRes, res);
        return res;
    }
    private void pathSum(TreeNode root, int sum, List<Integer> curRes, List<List<Integer>> res) {
        if (root == null) return;
        curRes.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new LinkedList<>(curRes));
            curRes.remove(curRes.size() - 1);
            return;
        } else {
            pathSum(root.left, sum - root.val, curRes, res);
            pathSum(root.right, sum - root.val, curRes, res);
        }
        curRes.remove(curRes.size() - 1);
    }
}
