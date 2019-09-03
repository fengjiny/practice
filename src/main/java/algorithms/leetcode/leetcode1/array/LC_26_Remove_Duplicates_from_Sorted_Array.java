package algorithms.leetcode.leetcode1.array;

public class LC_26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
