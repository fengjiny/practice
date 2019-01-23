package algorithms.leetcode_20181226.array;

public class LC_45_Jump_Game_II {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length; ++i) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                ++jumps;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
