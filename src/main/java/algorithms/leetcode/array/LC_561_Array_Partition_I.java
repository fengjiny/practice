package algorithms.leetcode.array;

public class LC_561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    private void qsort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            qsort(nums, p, q - 1);
            qsort(nums, q + 1, r);
        }
    }

    private int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (nums[j] < x) {
                ++i;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
