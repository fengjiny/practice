package algorithms.leetcode.leetcode_20190902.string;

public class LC_67_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; --i, --j) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            sb.append((x + y + carry) % 2);
            carry = (x + y + carry) >> 1;
        }
        return sb.reverse().toString();
    }
}
