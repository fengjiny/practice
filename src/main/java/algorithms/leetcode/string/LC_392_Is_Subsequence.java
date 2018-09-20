package algorithms.leetcode.string;

public class LC_392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length() && index < s.length(); ++i) {
            if (s.charAt(index) == t.charAt(i)) {
                ++index;
            }
        }
        return index == s.length();
    }
}
