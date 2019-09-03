package algorithms.leetcode.leetcode_20181226.tree;

import java.util.*;

public class LC_103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                tmp.add(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            if ((level++ & 1) != 1) {
                Collections.reverse(tmp);
            }
            res.add(tmp);
        }
        return res;
    }
}
