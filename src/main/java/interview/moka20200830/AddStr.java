package interview.moka20200830;

/**
 * 字符串相加，可能有负数
 */
public class AddStr {
    public String add(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; --i, --j) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = x + y + carry;
            sb.append(sum%10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
