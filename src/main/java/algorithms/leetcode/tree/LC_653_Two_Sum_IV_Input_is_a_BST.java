package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_653_Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, Set set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }


    /**
     * solution 2
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if ((list.get(i) + list.get(j)) == k) {
                return true;
            }
            if ((list.get(i) + list.get(j)) > k) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
