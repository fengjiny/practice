package algorithms.leetcode.leetcode1.math;

public class LC_461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            ++count;
            xor &= xor - 1;
        }
        return count;
    }
}

