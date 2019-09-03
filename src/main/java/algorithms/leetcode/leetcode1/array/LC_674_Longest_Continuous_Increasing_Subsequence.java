package algorithms.leetcode.leetcode1.array;

public class LC_674_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0, count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                ++count;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }
        return res;
    }
}
