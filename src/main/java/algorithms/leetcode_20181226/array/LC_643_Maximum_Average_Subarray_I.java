package algorithms.leetcode_20181226.array;

public class LC_643_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        long max = sum;
        for (int i = k; i < nums.length; ++i) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / 1.0 / k;
    }

    public static void main(String[] args) {
        int[] a = {-1};
        double d = new LC_643_Maximum_Average_Subarray_I().findMaxAverage(a, 1);
        System.out.println(d);
    }
}
