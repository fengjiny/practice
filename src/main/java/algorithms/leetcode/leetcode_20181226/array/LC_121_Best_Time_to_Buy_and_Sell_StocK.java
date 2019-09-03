package algorithms.leetcode.leetcode_20181226.array;

public class LC_121_Best_Time_to_Buy_and_Sell_StocK {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
