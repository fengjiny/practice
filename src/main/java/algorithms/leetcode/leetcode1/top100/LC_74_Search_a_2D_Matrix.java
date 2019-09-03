package algorithms.leetcode.leetcode1.top100;

public class LC_74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int mid_val = matrix[mid/col][mid%col];
            if (mid_val == target) {
                return true;
            } else if (mid_val < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
