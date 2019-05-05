package algorithms.leetcode_20181226.string;

import java.util.LinkedList;
import java.util.List;

public class LC_17_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); ++i) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char c : map[x].toCharArray()) {
                    ans.add(t + c);
                }
            }
        }
        return ans;
    }
}
