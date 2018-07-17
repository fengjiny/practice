package algorithms.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC_104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        int level = 0;
        if (root == null) return level;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            ++level;
        }
        return level;
    }
    public int solution(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(solution(root.left), solution(root.right));
    }

}
