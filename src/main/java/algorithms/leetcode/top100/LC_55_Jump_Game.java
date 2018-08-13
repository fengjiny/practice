package algorithms.leetcode.top100;

public class LC_55_Jump_Game {
    public boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; ++i) {
            reach = Math.max(reach, i + nums[i]);
        }
        return i == nums.length;
    }
}
