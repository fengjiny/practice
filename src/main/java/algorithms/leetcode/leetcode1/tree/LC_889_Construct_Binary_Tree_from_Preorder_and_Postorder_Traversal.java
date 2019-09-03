package algorithms.leetcode.leetcode1.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast();
                ++j;
            }
            if (s.getLast().left == null)
                s.getLast().left = node;
            else
                s.getLast().right = node;
            s.offer(node);
        }
        return s.getFirst();
    }
}
