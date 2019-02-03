package algorithms.leetcode_20181226.array;

import java.util.HashSet;

public class LC_219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; ++i) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
