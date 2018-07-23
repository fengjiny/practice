package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC_103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }
    private void travel(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() <= level) {
            List<Integer> list =  new LinkedList<>();
            res.add(list);
        }
        List<Integer> curLeval = res.get(level);
        if (level % 2 == 0) {
            curLeval.add(root.val);
        } else {
            curLeval.add(0, root.val);
        }
        travel(root.left, res, level + 1);
        travel(root.right, res, level + 1);
    }
}
