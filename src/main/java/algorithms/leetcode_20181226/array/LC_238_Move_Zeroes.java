package algorithms.leetcode_20181226.array;

public class LC_238_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public void top_sulotion(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int index = 0;
        for (int num : nums) {
            if (num != 0) nums[index++] = num;
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
