package algorithms.leetcode.lc_20200609.array;

public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        int a = search(nums, target);
        int b = search(nums, target + 1);
        if (a == nums.length || nums[a] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{a, b - 1};
    }

    private int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
