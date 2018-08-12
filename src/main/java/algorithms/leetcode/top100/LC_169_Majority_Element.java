package algorithms.leetcode.top100;

public class LC_169_Majority_Element {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                ++count;
                res = nums[i];
            } else if (nums[i] == res) {
                ++count;
            } else {
                --count;
            }
        }
        return res;
    }
}
