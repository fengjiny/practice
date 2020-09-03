package algorithms.leetcode.lc_20200609.array;

public class LC_45 {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == end) {
                end = curFarthest;
                ++jumps;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new LC_45().jump(nums));
    }
}
