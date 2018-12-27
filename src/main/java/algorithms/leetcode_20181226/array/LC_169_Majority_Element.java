package algorithms.leetcode_20181226.array;

public class LC_169_Majority_Element {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                res = nums[i];
                ++count;
            } else if (res == nums[i]){
                ++count;
            } else {
                --count;
            }
        }
        return res;
    }
}
