package algorithms.leetcode_20181226.bit;

public class LC_9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0;
        int tmp = x;
        while (tmp != 0){
            int tail = tmp % 10;
            int newRes = rev * 10 + tail;
            rev = newRes;
            tmp /= 10;
        }
        return rev == x;
    }

    public boolean isPalindrome_best(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}
