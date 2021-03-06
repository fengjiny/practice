package algorithms.leetcode.leetcode_20181226.array;

public class LC_566_Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; ++i) {
            res[i/c][i%c] = nums[i/n][i%n];
        }
        return res;
    }
}
