package algorithms.leetcode.leetcode_20181226.array;

import java.util.HashSet;

public class LC_217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
