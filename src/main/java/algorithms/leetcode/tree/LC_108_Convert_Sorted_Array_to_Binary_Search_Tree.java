package algorithms.leetcode.tree;

public class LC_108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0 , nums.length - 1);
    }
    private TreeNode helper(int[] nums, int i, int j) {
        if (i > j) return null;
        int mid = i + (j - i) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, i, mid - 1);
        node.right = helper(nums, mid + 1, j);
        return node;
    }
}
