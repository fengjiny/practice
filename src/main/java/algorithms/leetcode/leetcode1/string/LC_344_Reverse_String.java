package algorithms.leetcode.leetcode1.string;

public class LC_344_Reverse_String {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
        }
        return new String(ch);
    }
}
