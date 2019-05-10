package algorithms.leetcode_20181226.array;

import java.util.Arrays;

public class LC_215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    int quickSelect(int[] nums, int lo, int hi, int k) {
        int i = lo, j = hi, p = nums[hi];
        while (i < j) {
            if (nums[i++] > p) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);
        int m = i - lo + 1;
        if (m == k) return i;
        else if (m > k) return quickSelect(nums, lo, i - 1, k);
        else return quickSelect(nums, i + 1, hi, k - m);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
