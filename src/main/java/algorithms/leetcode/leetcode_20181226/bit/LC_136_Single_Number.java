package algorithms.leetcode.leetcode_20181226.bit;

public class LC_136_Single_Number {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        return xor;
    }
}
