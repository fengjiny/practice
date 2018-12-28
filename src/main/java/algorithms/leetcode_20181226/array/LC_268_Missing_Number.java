package algorithms.leetcode_20181226.array;

public class LC_268_Missing_Number {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (; i < nums.length; ++i) {
            xor ^= i ^ nums[i];
        }
        return xor ^ (i + 1);
    }
}
