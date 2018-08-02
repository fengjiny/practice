package algorithms.leetcode.math;

public class LC_191_Number_of_1_Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= n - 1;
        }
        return count;
    }
}
