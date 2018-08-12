package algorithms.leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequecyMap = new HashMap<>();
        for (int n : nums) {
            frequecyMap.put(n, frequecyMap.getOrDefault(n, 0) + 1);
        }
        for (int key : frequecyMap.keySet()) {
            int frequecy = frequecyMap.get(key);
            if (bucket[frequecy] == null) {
                bucket[frequecy] = new ArrayList<>();
            }
            bucket[frequecy].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; --pos) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
