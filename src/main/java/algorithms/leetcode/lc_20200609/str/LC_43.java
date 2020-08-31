package algorithms.leetcode.lc_20200609.str;

public class LC_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; --i) {
            StringBuffer tmp = new StringBuffer();
            for (int j = 0; j < num2.length() - 1 - i; ++j) {
                tmp.append(0);
            }
            int carry = 0;
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 || carry != 0; --j) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = n1 * n2 + carry;
                tmp.append(product%10);
                carry = product/10;
            }
            res = addStrings(res, tmp.reverse().toString());
        }
        return res;
    }

    private String addStrings(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; --i, --j) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = x + y + carry;
            sb.append(sum%10);
            carry = sum/10;
        }
        return sb.reverse().toString();
    }
}
