package algorithms.leetcode.lc_20200609;

public class LC_70 {
    public int climbStairs(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
