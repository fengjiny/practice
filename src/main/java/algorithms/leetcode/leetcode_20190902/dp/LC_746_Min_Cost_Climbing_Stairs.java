package algorithms.leetcode.leetcode_20190902.dp;

public class LC_746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; ++i) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
