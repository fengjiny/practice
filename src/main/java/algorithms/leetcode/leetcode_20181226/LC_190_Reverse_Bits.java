package algorithms.leetcode.leetcode_20181226;

public class LC_190_Reverse_Bits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res += n & 1;
            n >>>= 1;
            if (i < 31) res <<= 1;
        }
        return res;
    }
}
