package algorithms.leetcode.leetcode_20181226.array;

import algorithms.leetcode.leetcode1.array.PrintArray;


public class LC_88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,0,0,0};
        int[] b = {1,2,3};
        new LC_88_Merge_Sorted_Array().merge(a,3, b, 3);
        PrintArray.printArray(a);
    }
}
