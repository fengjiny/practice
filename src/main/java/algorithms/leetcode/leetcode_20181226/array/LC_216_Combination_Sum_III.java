package algorithms.leetcode.leetcode_20181226.array;

import java.util.ArrayList;
import java.util.List;

public class LC_216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combination(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= 9; ++i) {
            comb.add(i);
            combination(res, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }
}
