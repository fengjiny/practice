package algorithms.leetcode_20181226.array;

public class LC_852_Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; ++i) {
            if (A[i] > A[i + 1]) return i;
        }
        return 0;
    }
}
