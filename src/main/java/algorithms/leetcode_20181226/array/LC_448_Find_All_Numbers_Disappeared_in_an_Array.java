package algorithms.leetcode_20181226.array;

import java.util.ArrayList;
import java.util.List;

public class LC_448_Find_All_Numbers_Disappeared_in_an_Array {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) return res;
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        System.out.print(findDisappearedNumbers(array));
    }
}
