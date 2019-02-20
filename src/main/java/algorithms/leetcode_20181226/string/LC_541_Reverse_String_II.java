package algorithms.leetcode_20181226.string;

public class LC_541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length - 1; i += 2 * k) {
            if (k > ch.length || i + k - 1 > ch.length) {
                reverse(ch, i, ch.length - 1);
            } else {
                reverse(ch, i, i + k - 1);
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
