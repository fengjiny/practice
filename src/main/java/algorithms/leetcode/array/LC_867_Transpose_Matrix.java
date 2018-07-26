package algorithms.leetcode.array;

public class LC_867_Transpose_Matrix {
    public int[][] transpose(int[][] A) {
        int col = A.length - 1;
        int row = A[0].length - 1;
        int[][] res = new int[col][row];
        for (int[] nums : A) {
            for (int i = nums.length - 1; i >= 0; --i) {
                res[col--][row] = nums[i];
            }
            --row;
        }
        return A;
    }
}
