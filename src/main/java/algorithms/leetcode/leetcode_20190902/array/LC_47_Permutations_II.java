package algorithms.leetcode.leetcode_20190902.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_47_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums, boolean[] used) {
        if (tmpList.size() == nums.length) {
            list.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;
                used[i] = true;
                tmpList.add(nums[i]);
                backtrack(list, tmpList, nums, used);
                used[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
