package algorithms.leetcode.jianzhioffer;

public class jz_10_1_fib {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; ++i) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
    }
}
