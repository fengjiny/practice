package algorithms.leetcode_20181226.array;

public class LC_55_Jump_Game {
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int max = 0;
            if (i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
