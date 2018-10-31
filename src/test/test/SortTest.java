package test;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = {3,9,2,1,4,6,5,7,8,11,20,14,17};
        printArray(nums);
        quicksort(nums, 0 , nums.length - 1);
        printArray(nums);
    }

    private static void quicksort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            quicksort(nums, p, q - 1);
            quicksort(nums, q + 1, r);
        }
    }
    private static int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (nums[j] < x) {
                i += 1;
                swap(nums, i, j);
            }
        }
        i += 1;
        swap(nums, i, r);
        return i;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
