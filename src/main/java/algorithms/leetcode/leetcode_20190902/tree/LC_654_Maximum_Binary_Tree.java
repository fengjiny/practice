package algorithms.leetcode.leetcode_20190902.tree;

import algorithms.leetcode.TreeNode;

public class LC_654_Maximum_Binary_Tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIndex = start;
        for (int i = start + 1; i <= end; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = build(nums, start, maxIndex - 1);
        node.right = build(nums, maxIndex + 1, end);
        return node;
    }
}
