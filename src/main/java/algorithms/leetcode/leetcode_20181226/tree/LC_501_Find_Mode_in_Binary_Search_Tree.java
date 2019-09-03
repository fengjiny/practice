package algorithms.leetcode.leetcode_20181226.tree;

import java.util.ArrayList;
import java.util.List;

public class LC_501_Find_Mode_in_Binary_Search_Tree {
    Integer pre = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (pre != null) {
            if (root.val == pre)
                ++count;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        pre = root.val;
        traverse(root.right, list);
    }
}
