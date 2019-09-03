package algorithms.leetcode.leetcode_20181226;

import java.util.ArrayList;
import java.util.List;

public class LC_77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    private void combine(List<List<Integer>> res, List<Integer> tmp, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = start; i <= n; ++i) {
            tmp.add(i);
            combine(res, tmp, i + 1, n, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
