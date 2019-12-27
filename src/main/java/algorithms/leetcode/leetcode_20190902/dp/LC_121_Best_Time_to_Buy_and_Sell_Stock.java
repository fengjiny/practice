package algorithms.leetcode.leetcode_20190902.dp;

public class LC_121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
