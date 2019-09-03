package algorithms.leetcode.leetcode_20181226.array;

import java.util.ArrayList;
import java.util.List;

public class LC_442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] *= -1;
        }
        return res;
    }
}
