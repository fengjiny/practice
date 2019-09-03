package algorithms.leetcode.leetcode1.depth_first_search;

public class LC_338_Counting_Bits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            res[i] = countBit(i);
        }
        return res;
    }
    private int countBit(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= n - 1;
        }
        return count;
    }
}
