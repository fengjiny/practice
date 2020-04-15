package algorithms.leetcode.jianzhioffer;

public class jz_16_myPow {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        double res = 1;
        double curProduct = x;
        for (long i = N; i > 0 ; i /= 2) {
            if (i % 2 == 1) {
                res *= curProduct;
            }
            curProduct *= curProduct;
        }
        return res;
    }
}
