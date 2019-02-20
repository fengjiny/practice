package algorithms.leetcode_20181226.tree;

import java.util.HashSet;

public class LC_653_Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    private boolean dfs(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
