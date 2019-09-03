package algorithms.leetcode.leetcode_20181226.array;

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


    public double findMedianSortedArrays_binary(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 < n2) return findMedianSortedArrays_binary(nums2, nums1);
        int lo = 0, hi = n2 * 2;
        while (lo < hi) {
            int mid2 = (lo + hi) / 2;
            int mid1 = n1 + n2 - mid2;

            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1)/2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1)/2];
            double R1 = (mid1 == n1*2) ? Integer.MAX_VALUE : nums1[mid1/2];
            double R2 = (mid2 == n2*2) ? Integer.MAX_VALUE : nums2[mid2/2];
            if (L1 > R2) lo = mid2 + 1;
            else if (L2 > R1) hi = mid2 - 1;
            else return Math.max(L1, L2) + Math.min(R1, R2);
        }
        return -1;
    }
}
