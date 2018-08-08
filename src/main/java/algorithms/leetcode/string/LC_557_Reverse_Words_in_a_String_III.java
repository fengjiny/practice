package algorithms.leetcode.string;

public class LC_557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] != ' ') {
                int j = i;
                while (j + 1 < ch.length && ch[j + 1] != ' ') {
                    ++j;
                }
                reverse(ch, i, j);
                i = j;
            }
        }
        return new String(ch);
    }
    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char tmp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = tmp;
        }
    }
}
