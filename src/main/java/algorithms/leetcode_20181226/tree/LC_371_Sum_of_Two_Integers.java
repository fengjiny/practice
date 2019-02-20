package algorithms.leetcode_20181226.tree;

public class LC_371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return sum;
    }
}
