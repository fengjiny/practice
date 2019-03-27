package algorithms.leetcode_20181226.string;

public class LC_5_Longest_Palindromic_Substring {
    int index, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        for (int i = 0; i < s.length(); ++i) {
            extendPalindromic(s, i, i);
            extendPalindromic(s, i, i + 1);
        }
        return s.substring(index, index + maxLen);
    }
    private void extendPalindromic(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            index = i + 1;
            maxLen = j - i - 1;
        }
    }
}
