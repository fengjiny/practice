package algorithms.leetcode.jianzhioffer;

public class JZ_62_lastRemaining {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; ++i) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
