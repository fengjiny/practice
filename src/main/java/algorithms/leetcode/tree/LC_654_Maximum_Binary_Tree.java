package algorithms.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class LC_654_Maximum_Binary_Tree {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode head = sulotion2(nums);
        PrintTree.printTree(head);
    }


    public  static TreeNode constructMaximumBinaryTree(int[] nums) {
        return solution1(nums, 0, nums.length - 1);
    }


    private static TreeNode solution1(int[] nums, int i, int j) {
        if (i > j) return null;
        int maxIdx = maxIdx(nums, i, j);
        TreeNode head = new TreeNode(nums[maxIdx]);
        head.left = solution1(nums, i, maxIdx - 1);
        head.right = solution1(nums, maxIdx + 1, j);
        return head;
    }

    private static int maxIdx(int[] nums, int start, int end) {
        int max = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; ++i) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    private static TreeNode sulotion2(int[] nums) {
        Deque<TreeNode> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            TreeNode node = new TreeNode(nums[i]);
            while (!deque.isEmpty() && deque.peek().val < nums[i]) {
                node.left = deque.pop();
            }
            if (!deque.isEmpty()) {
                deque.peek().right = node;
            }
            deque.push(node);
        }
        return deque.peekLast();
    }
}
