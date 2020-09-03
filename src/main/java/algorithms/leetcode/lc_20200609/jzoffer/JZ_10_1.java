package algorithms.leetcode.lc_20200609.jzoffer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 */
public class JZ_10_1 {
    public int fib(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
