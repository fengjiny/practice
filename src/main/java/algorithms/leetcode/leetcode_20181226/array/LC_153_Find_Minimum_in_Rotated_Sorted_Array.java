package algorithms.leetcode.leetcode_20181226.array;

public class LC_153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) return nums[start];
            int mid = (start + end) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
