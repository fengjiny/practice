package algorithms.leetcode.leetcode1.array;

public class LC_189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , nums.length - 1);
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
