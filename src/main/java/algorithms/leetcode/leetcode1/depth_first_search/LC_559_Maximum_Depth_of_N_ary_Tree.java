package algorithms.leetcode.leetcode1.depth_first_search;

public class LC_559_Maximum_Depth_of_N_ary_Tree {
    int max = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        dfs(root, 1);
        return max;
    }
    private void dfs(Node root, int depth) {
        if (root == null) return;
        max = Math.max(max, depth);
        for (Node node : root.children) {
            dfs(node, depth + 1);
        }
    }
}
