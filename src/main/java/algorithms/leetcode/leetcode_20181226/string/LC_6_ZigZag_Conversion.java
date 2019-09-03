package algorithms.leetcode.leetcode_20181226.string;

public class LC_6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; ++i) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; ++idx) {
                sb[idx].append(ch[i++]);
            }
            for (int idx = numRows - 2;idx >= 1 && i < len; idx--) {
                sb[idx].append(ch[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}
