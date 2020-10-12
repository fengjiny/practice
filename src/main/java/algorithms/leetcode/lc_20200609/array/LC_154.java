package algorithms.leetcode.lc_20200609.array;

public class LC_154 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]){
                r = m;
            } else {
                --r;
            }
        }
        return l;
    }
}
