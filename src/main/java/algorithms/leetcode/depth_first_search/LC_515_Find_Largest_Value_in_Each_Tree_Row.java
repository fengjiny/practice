package algorithms.leetcode.depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class LC_515_Find_Largest_Value_in_Each_Tree_Row {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int d) {
        if (root == null) return;
        if (d == res.size()) {
            res.add(root.val);
        }
        else {
            res.set(d, Math.max(res.get(d), root.val));
        }
        dfs(root.left, res, d + 1);
        dfs(root.right, res, d + 1);
    }
}
