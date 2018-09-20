package algorithms.leetcode.array;

public class LC_746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; ++i) {
            int costV = (i == cost.length ? 0 : cost[i]);
            dp[i] = costV + Math.min(dp[i - 2], dp[i - 1]);
        }
        return dp[cost.length];
    }
}
