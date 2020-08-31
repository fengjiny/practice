package algorithms.leetcode.lc_20200609.array;

public class LC_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
