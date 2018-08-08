package algorithms.ita.chapter_4;

public class quickSort {
    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5,7,6,8,9,10,20,11,25};
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(nums,0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }



    public static void quickSort(int[] nums, int p, int r) {
        if(p < r) {
            int q = partition(nums, p, r);
            quickSort(nums, p, q - 1);
            quickSort(nums,q + 1, r);
        }
    }

    public static int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (nums[j] <= x) {
                i += 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i+ 1, r);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
