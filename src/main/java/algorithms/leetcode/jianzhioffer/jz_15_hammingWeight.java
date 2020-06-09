package algorithms.leetcode.jianzhioffer;

public class jz_15_hammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            ++count;
            n &= n - 1;
        }
        return count;
    }
}
