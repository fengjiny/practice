package algorithms.leetcode.leetcode_20181226.array;

public class LC_485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                ++count;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
