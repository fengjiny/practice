package algorithms.leetcode.leetcode_20181226.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC_559_Maximum_Depth_of_N_ary_Tree {
    public int maxDepth_BFS(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                root = queue.poll();
                for (Node node : root.children) {
                    if (node != null)
                        queue.offer(node);
                }
            }
            ++depth;
        }
        return depth;
    }


    private int max = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        maxDepth(root, 1);
        return max;
    }

    private void maxDepth(Node root, int depth) {
        if (root == null) return;
        max = Math.max(max, depth);
        for (Node node : root.children) {
            maxDepth(node, depth + 1);
        }
    }
}
