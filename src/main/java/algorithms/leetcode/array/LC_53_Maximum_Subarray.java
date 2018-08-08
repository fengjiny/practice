package algorithms.leetcode.array;

public class LC_53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxCur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(max, maxCur);
        }
        return max;
    }


    public int maxSubArray_DP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
