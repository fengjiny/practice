package algorithms.leetcode.leetcode1.array;

public class LC_566_Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (r * c != row * col) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; ++i) {
            res[i/c][i%c] = nums[i/col][i%col];
        }
        return res;
    }
}
