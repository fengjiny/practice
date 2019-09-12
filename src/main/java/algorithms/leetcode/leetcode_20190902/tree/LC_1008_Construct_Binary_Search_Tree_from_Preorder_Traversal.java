package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

public class LC_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) return null;
        return build(preorder, 0, preorder.length - 1);
    }
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int idx = start;
        for (int i = start + 1; i <= end; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i - 1;
                break;
            }
        }
        TreeNode node = new TreeNode(nums[start]);
        node.left = build(nums, start + 1, idx);
        node.right = build(nums, idx + 1, end);
        return node;
    }
}
