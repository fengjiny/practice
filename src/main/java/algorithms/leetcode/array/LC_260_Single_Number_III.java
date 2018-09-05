package algorithms.leetcode.array;

import java.util.Arrays;

public class LC_260_Single_Number_III {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff = Integer.highestOneBit(diff);
        int[] res = new int[2];
        Arrays.fill(res, 0);
        for (int num : nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            }
            else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
