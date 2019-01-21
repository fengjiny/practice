package algorithms.leetcode_20181226.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer>[] frequent = new List[nums.length + 1];
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        map.forEach((key, value) -> {
            if (frequent[value] == null) {
                frequent[value] = new ArrayList<>();
            }
            frequent[value].add(key);
        });
        List<Integer> res = new ArrayList<>();
        for (int i = frequent.length - 1; i >= 0 && res.size() < k; --i) {
            if (frequent[i] != null) {
                res.addAll(frequent[i]);
            }
        }
        return res;

    }
}
