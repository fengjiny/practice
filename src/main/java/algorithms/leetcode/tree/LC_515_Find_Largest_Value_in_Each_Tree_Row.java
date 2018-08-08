package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_515_Find_Largest_Value_in_Each_Tree_Row {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                if (root.val > max) {
                    max = root.val;
                }
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            res.add(max);
        }
        return res;
    }
}
