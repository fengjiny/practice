package algorithms.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class LC_865_Smallest_Subtree_with_all_the_Deepest_Nodes {

    Map<TreeNode, Integer> map = new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return root;
        depth(root);
        return dfs(root);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int max = Math.max(depth(root.left), depth(root.right)) + 1;
        map.put(root, max);
        return max;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) return root;
        if (left > right) return dfs(root.left);
        return dfs(root.right);
    }
}
