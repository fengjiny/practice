package algorithms.leetcode.array;

public class LC_122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }
}
