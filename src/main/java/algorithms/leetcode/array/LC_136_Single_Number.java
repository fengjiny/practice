package algorithms.leetcode.array;

public class LC_136_Single_Number {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
        }
        return res;
    }
}
