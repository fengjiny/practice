package algorithms.leetcode.leetcode_20190902.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC_287_Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
    }
}
