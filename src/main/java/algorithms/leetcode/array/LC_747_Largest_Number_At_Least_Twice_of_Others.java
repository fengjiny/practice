package algorithms.leetcode.array;

public class LC_747_Largest_Number_At_Least_Twice_of_Others {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int max = Integer.MIN_VALUE + 1;
        int secend = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                secend = max;
                max = nums[i];
                index = i;
            } else if (nums[i] != max && nums[i] > secend) {
                secend = nums[i];
            }
        }
        if (max >= secend * 2) {
            return index;
        }
        return -1;
    }
}
