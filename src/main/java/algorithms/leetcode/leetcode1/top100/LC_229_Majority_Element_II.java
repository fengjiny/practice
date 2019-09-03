package algorithms.leetcode.leetcode1.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            if (count > (nums.length / 3.0) && !list.contains(i)) {
                list.add(i);
            }
            map.put(i, count);
        }
        return list;
    }
}
