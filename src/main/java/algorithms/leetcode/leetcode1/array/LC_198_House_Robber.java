package algorithms.leetcode.leetcode1.array;

public class LC_198_House_Robber {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }
        return Math.max(a, b);
    }
}
