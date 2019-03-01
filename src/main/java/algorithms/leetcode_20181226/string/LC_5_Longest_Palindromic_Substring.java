package algorithms.leetcode_20181226.string;

public class LC_5_Longest_Palindromic_Substring {
    int index;
    public String longestPalindrome(String s) {
        String res = null;
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (s.charAt(i) == s.charAt(j) && isPalindrome(s, i, j)) {

                max = j - i;
                res = s.substring(i, j);
            }
        }
        return res;
    }
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
