package algorithms.leetcode.lc_20200609.array;

public class LC_167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target){
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                --r;
            } else {
                ++l;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int[] res = new LC_167().twoSum(nums, 9);
        System.out.println(res);
    }
}
