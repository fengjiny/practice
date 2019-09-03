package algorithms.leetcode.leetcode_20181226.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            res.add(root.val);
        }
        return res;
    }

    public List<Integer> rightSideView_recurse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(root, res, 0);
        return res;
    }

    private void rightView(TreeNode root, List<Integer> res, int curDepth) {
        if (root == null) return;
        if (curDepth == res.size()) {
            res.add(root.val);
        }
        rightView(root.right, res, curDepth + 1);
        rightView(root.left, res, curDepth + 1);
    }
}
