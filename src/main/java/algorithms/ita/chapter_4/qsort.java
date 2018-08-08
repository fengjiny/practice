package algorithms.ita.chapter_4;

public class qsort {
    public static void main(String[] args) {
        int[] nums = {3,9,2,1,4,6,5,7,8,11,20,14,17};
        printArray(nums);
        qSort(nums, 0 , nums.length - 1);
        printArray(nums);
    }

    public static void qSort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            qSort(nums, p, q - 1);
            qSort(nums, q + 1, r);
        }
    }

    private static int partition(int[] nums, int p, int r){
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (nums[j] < x) {
                i += 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
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
