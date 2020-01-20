package algorithms.leetcode.leetcode_20190902.string;

import java.util.LinkedList;
import java.util.List;

public class LC_415_Add_Strings {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; --i, --j) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry)%10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "6", num2 = "501";
        System.out.println(new LC_415_Add_Strings().addStrings(num1, num2));
    }
}
