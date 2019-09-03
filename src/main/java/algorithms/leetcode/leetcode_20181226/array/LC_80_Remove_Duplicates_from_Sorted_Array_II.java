package algorithms.leetcode.leetcode_20181226.array;

import algorithms.Utils;

public class LC_80_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int res = new LC_80_Remove_Duplicates_from_Sorted_Array_II().removeDuplicates(nums);
        System.out.println(res);
        Utils.printArray(nums);
    }
}
