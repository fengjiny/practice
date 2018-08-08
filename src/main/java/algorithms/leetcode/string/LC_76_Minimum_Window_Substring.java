package algorithms.leetcode.string;

import java.util.HashMap;

public class LC_76_Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() | s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); ++right) {

        }
    }

    public static void main(String[] args) {
        //S = "ADOBECODEBANC", T = "ABC"
        String s = "ADOBECODEBANC";
        String t = "ABC";
    }
}
