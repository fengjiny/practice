package algorithms.leetcode.array;

public class LC_371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        int sum , carry;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
