package algorithms.leetcode.leetcode_20181226.array;

import java.util.Arrays;

public class LC_977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            A[i] = (int) Math.pow(A[i], 2);
        }
//        quickSort(A, 0, A.length - 1);
        Arrays.sort(A);
        return A;
    }
    private void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A ,p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    private int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (A[j] < x) {
                swap(A ,++i, j);
            }
        }
        swap(A, ++i, r);
        return i;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }


    public int[] sortedSquares_merge(int[] A) {
        int n = A.length;
        int l = 0, r = n - 1;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                res[i] = A[l] * A[l];
                ++l;
            } else {
                res[i] = A[r] * A[r];
                --r;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(Math.pow(3, 2));
    }
}
