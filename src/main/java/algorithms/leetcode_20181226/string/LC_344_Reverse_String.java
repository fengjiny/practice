package algorithms.leetcode_20181226.string;

public class LC_344_Reverse_String {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}
