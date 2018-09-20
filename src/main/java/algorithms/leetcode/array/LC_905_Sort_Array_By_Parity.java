package algorithms.leetcode.array;

public class LC_905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] A) {
        int begin = 0, end = A.length - 1;
        while (begin < end) {
            if ((A[begin] % 2) != 0 && (A[end] % 2 == 0)) {
                swap(A, begin++, end--);
            }
            else if (A[begin] % 2 == 0) {
                ++begin;
            }
            else if (A[end] % 2 != 0) {
                --end;
            }
        }
        return A;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
