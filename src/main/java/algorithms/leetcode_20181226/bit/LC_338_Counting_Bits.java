package algorithms.leetcode_20181226.bit;

public class LC_338_Counting_Bits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            res[i] = bitOnes(i);
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
