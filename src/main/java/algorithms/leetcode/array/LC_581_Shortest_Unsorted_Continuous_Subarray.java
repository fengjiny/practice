package algorithms.leetcode.array;

public class LC_581_Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            if (nums[i] < max) end = i;
            if (nums[n - i - 1] > min) beg = n - i - 1;
        }
        return end - beg + 1;
    }
}
