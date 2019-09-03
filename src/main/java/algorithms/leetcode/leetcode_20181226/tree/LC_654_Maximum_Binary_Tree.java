package algorithms.leetcode.leetcode_20181226.tree;

public class LC_654_Maximum_Binary_Tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIdx = start;
        for (int i = start; i <= end; ++i) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = build(nums, start, maxIdx - 1);
        root.right = build(nums, maxIdx + 1, end);
        return root;
    }
}
