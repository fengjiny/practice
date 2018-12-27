package algorithms.leetcode_20181226.array;

public class LC_922_Sort_Array_By_Parity_II {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n) {
            if (i < n && A[i] % 2 == 0) {
                i += 2;
            }
            if (j < n && A[j] %2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
