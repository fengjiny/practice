package algorithms.leetcode.top100;

public class LC_461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            xor &= xor - 1;
            ++count;
        }
        return count;
    }
}
