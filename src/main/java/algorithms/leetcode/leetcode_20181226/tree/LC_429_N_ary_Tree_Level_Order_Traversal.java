package algorithms.leetcode.leetcode_20181226.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_429_N_ary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                root = queue.poll();
                tmp.add(root.val);
                for (Node node : root.children) {
                    queue.offer(node);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
