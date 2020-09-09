package algorithms.leetcode.lc_20200609.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC_40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new Stack<Integer>());
        return res;
    }

    private void dfs(int[] candidates, int begin, int target, Stack<Integer> stack) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(stack));
        }
        for (int i = begin; i < candidates.length; ++i) {
            if (i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }
            stack.push(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], stack);
            stack.pop();
        }
    }
}
