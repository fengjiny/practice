package algorithms.leetcode.leetcode_20181226.bit;

public class LC_137_Single_Number_II {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; ++i) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
            System.out.println("ones : "+ones);
            System.out.println("twos : "+twos);
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,5};
        new LC_137_Single_Number_II().singleNumber(nums);
    }
}
