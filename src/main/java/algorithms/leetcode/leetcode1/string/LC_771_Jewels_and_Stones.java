package algorithms.leetcode.leetcode1.string;

import java.util.HashSet;
import java.util.Set;

public class LC_771_Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> s = new HashSet<>();
        for(char c : J.toCharArray()) {
            s.add(c);
        }
        for(char c : S.toCharArray()) {
            if (s.contains(c)) {
                ++count;
            }
        }
        return count;
    }
    public static int numJewelsInStones2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public static void main(String[] args) {
        String s = "aAAbbbb";
        String j = "aA";
        System.out.print(numJewelsInStones2(j, s));
    }
}
