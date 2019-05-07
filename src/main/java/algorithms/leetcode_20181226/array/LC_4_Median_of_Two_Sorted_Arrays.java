package algorithms.leetcode_20181226.array;

public class LC_4_Median_of_Two_Sorted_Arrays  {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0, index = 0;
        int[] array = new int[(n1 + n2)/2 + 1];
        while (index < array.length) {
            if (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    array[index++] = nums1[i++];
                } else {
                    array[index++] = nums2[j++];
                }
            } else if (i >= n1 && j < n2) {
                array[index++] = nums2[j++];
            } else if (i < n1 && j >= n2) {
                array[index++] = nums1[i++];
            }
        }
        if (((n1 + n2)&1) == 0) {
            return (array[array.length - 1] + array[array.length - 2]) * 0.5;
        } else {
            return array[array.length - 1];
        }
    }
}
