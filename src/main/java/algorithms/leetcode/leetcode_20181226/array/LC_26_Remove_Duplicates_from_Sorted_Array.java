package algorithms.leetcode.leetcode_20181226.array;

public class LC_26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 1;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
