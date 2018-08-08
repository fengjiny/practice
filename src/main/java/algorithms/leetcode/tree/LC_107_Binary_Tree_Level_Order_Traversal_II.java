package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                root = q.poll();
                list.add(root.val);
                if (root.left != null) q.offer(root.left);
                if (root.right != null) q.offer(root.right);
            }
            res.addFirst(list);
        }
        return res;
    }
}
