package algorithms.leetcode.jianzhioffer;

public class JZ_39_majorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                res = nums[i];
                ++count;
            } else if (nums[i] == res) {
                ++count;
            } else {
                --count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {8,8,7,7,7};
        System.out.println(new JZ_39_majorityElement().majorityElement(a));
    }
}
