package test;

import algorithms.Utils;

public class QuickSortTest {
    public void quickSort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            quickSort(nums, p, q - 1);
            quickSort(nums, q + 1, r);
        }
    }
    private int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (nums[j] < x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, r);
        return i;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,1,2,7,0,9};
        new QuickSortTest().quickSort(nums, 0, nums.length - 1);
        Utils.printArray(nums);
    }
}
