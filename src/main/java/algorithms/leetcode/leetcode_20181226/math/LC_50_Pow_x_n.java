package algorithms.leetcode.leetcode_20181226.math;

public class LC_50_Pow_x_n {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1/x;
            return n%2 == 0 ? myPow(x*x, -(n/2)) : x * myPow(x*x, -(n/2));
        }
        return n % 2 == 0 ? myPow(x * x, n/2) : x * myPow(x * x, n / 2);
    }
}
