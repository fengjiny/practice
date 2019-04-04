package algorithms.leetcode_20181226.string;

public class LC_76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            ++map[c];
        }
        int counter = t.length(), begin = 0, end = 0, window = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            char endc = s.charAt(end++);
            if (map[endc]-- > 0) {
                --counter;
            }
            while (counter == 0) {
                if (end - begin < window) window = end - (head = begin);
                char beginc = s.charAt(begin++);
                if (map[beginc]++ == 0) ++counter;
            }
        }
        return window == Integer.MAX_VALUE ? "" : s.substring(head, head + window);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new LC_76_Minimum_Window_Substring().minWindow(s,t));
    }
}
