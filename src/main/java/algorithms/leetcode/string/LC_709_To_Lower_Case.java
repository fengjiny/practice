package algorithms.leetcode.string;

public class LC_709_To_Lower_Case {
    public String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if ('A' <= ch[i] && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] - 'A' + 'a');
            }
        }
        return new String(ch);
    }
}
