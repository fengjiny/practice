package algorithms.leetcode.jianzhioffer;


import algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JZ_55_I_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
    }
}
