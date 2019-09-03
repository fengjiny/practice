package algorithms.leetcode.leetcode1.top100;

import java.util.Arrays;

public class LC_215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
