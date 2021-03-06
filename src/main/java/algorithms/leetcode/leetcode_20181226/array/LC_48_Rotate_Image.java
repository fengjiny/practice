package algorithms.leetcode.leetcode_20181226.array;

public class LC_48_Rotate_Image {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i; i < matrix[0].length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length/2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
