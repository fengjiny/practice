package algorithms.leetcode.lc_20200609.array;

import java.util.HashMap;
import java.util.Map;

public class LC_03 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left );
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcdd";
        System.out.println(new LC_03().lengthOfLongestSubstring(s));
    }
}
