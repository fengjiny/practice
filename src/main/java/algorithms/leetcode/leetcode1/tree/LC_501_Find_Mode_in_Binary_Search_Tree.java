package algorithms.leetcode.leetcode1.tree;

import java.util.*;

public class LC_501_Find_Mode_in_Binary_Search_Tree {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        int count = map.getOrDefault(root.val, 0) + 1;
        max = Math.max(max, count);
        map.put(root.val, count);
        inOrder(root.right);
    }
}

class solution2{
    List<Integer> list = new ArrayList<>();
    Integer pre = null;
    int count = 1;
    int max = 0;

    public int[] findMode_2(TreeNode root) {
        traverse(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (pre != null) {
            if (pre == root.val) {
                 ++count;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        pre = root.val;
        traverse(root.right);
    }
}
