

/**
 * 字符串相加，可能有负数
 */
public class AddStr {
    public String add(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        int aLength = a.length(), bLength = b.length();
        int len = Math.max(a.length(), bLength) + 1;
        int[] res = new int[len + 1];
        int i = aLength - 1, j = bLength - 1, r = res.length - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i--) + b.charAt(j--) - 32 + carry;
            carry = sum%10 > 1 ? 1 : 0;
            res[r--] = sum/10;
        }

        if (i < 0) {
            while(j>=0) {
                res[r--] = b.charAt(j--);
            }
        }

    }
}
