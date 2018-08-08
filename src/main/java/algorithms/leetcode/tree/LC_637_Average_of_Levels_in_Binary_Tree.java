package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_637_Average_of_Levels_in_Binary_Tree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                sum += root.val;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            res.add(sum / size);
        }
        return res;
    }
}
