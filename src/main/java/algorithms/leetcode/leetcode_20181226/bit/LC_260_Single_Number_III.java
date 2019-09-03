package algorithms.leetcode.leetcode_20181226.bit;

public class LC_260_Single_Number_III {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        System.out.println(xor);
        xor &= -xor;
        System.out.println(xor);
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & xor) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,1,2,3,4,4,5,5,6};
//        new LC_260_Single_Number_III().singleNumber(nums);

    }
}
