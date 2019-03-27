package algorithms.leetcode_20181226.bit;

public class LC_231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
