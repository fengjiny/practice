package algorithms.leetcode.lc_20200609.array;

public class LC_122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        for (int i = 0; i < n - 1; ++i) {
            int dif = prices[i + 1] - prices[i];
            if (dif> 0) {
                res += dif;
            }
        }
        return res;
    }
}
