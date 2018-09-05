package algorithms.jianzhi;

/**
 * 构建乘积数组
 */

public class Multiply {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; ++i) {
            res[i] = res[i - 1] * A[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= right;
            right *= A[i];
        }
        return res;
    }
}
