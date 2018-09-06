public class test {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,9,8,7};
        qsort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i);
        }
    }
    private static void amount(double htPrice) {
        int ht = 10283;
        double sum = ht * htPrice + 2366;
        System.out.println(sum);
    }
    private static void qsort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            qsort(nums, p, q - 1);
            qsort(nums, q + 1, r);
        }
    }
    private static int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (nums[j] < x) {
                ++i;
                swap(nums, i,j);
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
}
