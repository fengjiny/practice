package algorithms.leetcode.leetcode_20190902.array;

public class LC_55_Jump_Game {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
