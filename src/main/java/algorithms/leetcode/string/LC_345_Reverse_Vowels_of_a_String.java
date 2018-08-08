package algorithms.leetcode.string;

public class LC_345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0, end = ch.length - 1;
        while (start < end) {
            while (start < end && !vowels.contains(ch[start] + "")) {
                ++start;
            }
            while (start < end && !vowels.contains(ch[end] + "")) {
                --end;
            }
            char tmp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = tmp;
        }
        return new String(ch);
    }
}
