package algorithms.leetcode_20181226.string;

public class LC_557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        for (int j = 0; j < ch.length; ++j) {
            if (ch[j] == ' ') {
                reverse(ch, i, j - 1);
                i = j + 1;
            }
             if (j == ch.length - 1) {
                reverse(ch, i, j);
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

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = new LC_557_Reverse_Words_in_a_String_III().reverseWords(s);
        System.out.println(s);
    }
}
