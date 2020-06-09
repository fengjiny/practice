package algorithms.leetcode.jianzhioffer;

import java.util.Arrays;

public class JZ_40_getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int l, int r, int k) {
        int j = partition(nums, l, r);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        return j > k ? quickSearch(nums, l, j - 1, k) : quickSearch(nums, j + 1, r, k);
    }

    private int partition(int[] nums, int l, int r) {
        int q = nums[l];
        int i = l, j = r + 1;
        while (true) {
            while (++i < r && nums[i] < q);
            while (--j > l && nums[j] > q);
            if (i >= j) {
                break;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        nums[l] = nums[j];
        nums[j] = q;
        return j;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = Arrays.copyOf(a, 3);
        System.out.println(b);
    }
}
