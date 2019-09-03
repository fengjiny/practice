package algorithms.leetcode.leetcode_20181226.string;

public class LC_14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                System.out.println(pre);
            }
            ++i;
        }
        return pre;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        new LC_14_Longest_Common_Prefix().longestCommonPrefix(strs);
        String a = "alow", b = "fl";
        System.out.println(a.indexOf(b));
    }
}
