package algorithms.leetcode.leetcode1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC_113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentResult = new LinkedList<>();
        path(root, res, currentResult, sum);
        return res;
    }
    private void path(TreeNode root, List<List<Integer>> res, List<Integer> currentResult, int sum) {
        if (root == null) return;
        currentResult.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(currentResult));
            currentResult.remove(currentResult.size() - 1);
            return;
        } else {
            path(root.left, res, currentResult, sum - root.val);
            path(root.right, res, currentResult, sum - root.val);
        }
        currentResult.remove(currentResult.size() - 1);
    }
}
