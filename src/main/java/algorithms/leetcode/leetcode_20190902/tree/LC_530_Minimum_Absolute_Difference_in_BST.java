package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_530_Minimum_Absolute_Difference_in_BST {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); ++i) {
            int dif = Math.abs(list.get(i) - list.get(i - 1));
            if (dif < min) min = dif;
        }
        return min;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    int min = Integer.MAX_VALUE;
    Integer pre = null;
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference2(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        getMinimumDifference2(root.right);
        return min;

    }
}
