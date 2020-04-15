package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

public class jz_26_isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        return a.val == b.val && dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
