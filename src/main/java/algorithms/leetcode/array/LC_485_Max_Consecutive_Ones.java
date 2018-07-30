package algorithms.leetcode.array;

public class LC_485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLenth = 0;
        int length = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                length = 0;
            } else {
                ++length;
            }
            maxLenth = Math.max(maxLenth, length);
        }
        return maxLenth;
    }
}
