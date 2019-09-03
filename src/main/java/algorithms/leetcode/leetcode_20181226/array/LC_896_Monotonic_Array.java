package algorithms.leetcode.leetcode_20181226.array;

public class LC_896_Monotonic_Array {
    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i] >= A[i - 1];
            dec &= A[i] <= A[i - 1];
        }
        return inc || dec;
    }

    public boolean isMonotonic_2(int[] A) {
        if (A.length == 1) return true;
        int n = A.length;
        boolean up = (A[n - 1] > A[0]);
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] != A[i + 1] && (A[i + 1] > A[i]) != up) {
                return false;
            }
        }
        return true;
    }
}
