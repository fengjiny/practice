package algorithms.leetcode.array;

public class LC_35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
