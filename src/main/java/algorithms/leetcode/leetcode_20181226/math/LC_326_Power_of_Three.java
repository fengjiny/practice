package algorithms.leetcode.leetcode_20181226.math;

public class LC_326_Power_of_Three {
    public boolean isPowerOfThree(int n) {
        if (n > 1)
            while (n % 3 == 0)
                n /= 3;
        return n == 1;
    }
}
