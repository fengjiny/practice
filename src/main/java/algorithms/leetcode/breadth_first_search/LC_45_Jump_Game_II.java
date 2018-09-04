package algorithms.leetcode.breadth_first_search;

public class LC_45_Jump_Game_II {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        int level = 0, currentMax = 0, i = 0, nextMax = 0;
        while (currentMax - i + 1 > 0) {
            level++;
            for (; i <= currentMax; ++i) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) return level;
            }
            currentMax = nextMax;
        }
        return 0;
    }
}
