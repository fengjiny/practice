package algorithms.leetcode.leetcode_20181226.bit;

public class LC_693_Binary_Number_with_Alternating_Bits {
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & (n + 1)) == 0;
    }
}
