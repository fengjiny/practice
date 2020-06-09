package algorithms.leetcode.jianzhioffer;

import java.util.LinkedHashMap;
import java.util.Map;

public class JZ_50_firstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> e : map.entrySet()) {
            if (e.getValue()) {
                return e.getKey();
            }
        }
        return ' ';
    }
}
