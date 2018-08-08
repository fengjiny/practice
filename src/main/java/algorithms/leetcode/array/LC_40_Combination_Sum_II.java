package algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_40_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, res);
        return res;
    }

    private void dfs(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; ++i) {
            if (i > cur && cand[i] == cand[i - 1]) continue;
            path.add(path.size(), cand[i]);
            dfs(cand, i + 1, target - cand[i], path, res);
            path.remove(path.size() - 1);
        }
    }

}
