package algorithms.leetcode.leetcode_20190902.array;

public class LC_45_Jump_Game_II {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                ++jumps;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
    }
}
