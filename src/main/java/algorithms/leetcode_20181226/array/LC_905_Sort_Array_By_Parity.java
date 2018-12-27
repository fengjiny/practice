package algorithms.leetcode_20181226.array;

public class LC_905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; ++j) {
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
