package algorithms.leetcode.leetcode_20181226.bit;

public class LC_477_Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for(int j = i; j < nums.length; ++j) {
                int xor = nums[i] ^ nums[j];
                res += bitOnes(xor);
            }
        }
        return res;
    }
    private int bitOnes(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= n - 1;
        }
        return count;
    }
}
