package algorithms.leetcode.lc_20200609.array;

import java.util.HashSet;
import java.util.Set;

public class LC_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() < nums.length;
    }
}
