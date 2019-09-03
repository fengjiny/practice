package algorithms.leetcode.leetcode_20181226.array;

import algorithms.Utils;

public class LC_66_Plus_One {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = carry;
        for (int i = 1; i < res.length; ++i) {
            res[i] = digits[i - 1];
        }
        return res;
    }

    public int[] plusOne_best(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }


    public static void main(String[] args) {
        int[] a = {9};
        int[] res = new LC_66_Plus_One().plusOne(a);
        Utils.printArray(res);
    }
}
