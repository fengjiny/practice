package algorithms.leetcode.lc_20200609.str;

public class LC_541 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        int i = 0, n = s.length() - 1;
        while(i < n) {
            int j = Math.min(i + k - 1, n);
            reverse(ch, i, j);
            i += 2*k;
        }
        return new String(ch);
    }

    private void reverse(char[] ch, int i, int j) {
        while(i < j) {
            char tmp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = tmp;
        }
    }
}
