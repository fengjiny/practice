package algorithms.leetcode.leetcode_20181226.array;

public class LC_867_Transpose_Matrix {
    public int[][] transpose(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }
}
