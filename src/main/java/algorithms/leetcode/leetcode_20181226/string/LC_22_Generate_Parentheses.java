package algorithms.leetcode.leetcode_20181226.string;

import java.util.ArrayList;
import java.util.List;

public class LC_22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, "",0 ,0, n);
        return list;
    }
    private void backTrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2){
            list.add(str);
            return;
        }
        if (open < max)
            backTrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backTrack(list, str + ")", open, close + 1, max);
    }
}
