package algorithms.leetcode.leetcode_20181226.string;

import java.util.Arrays;
import java.util.Comparator;

public class LC_179_Largest_Number {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] s_num = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            s_num[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(s_num, comp);
        if (s_num[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : s_num) {
            sb.append(s);
        }
        return sb.toString();
    }
}
