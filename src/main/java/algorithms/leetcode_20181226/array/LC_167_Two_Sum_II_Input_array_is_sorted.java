package algorithms.leetcode_20181226.array;

public class LC_167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length, begin = 0, end = n - 1;
        int[] res = new int[2];
        while (begin < end) {
            int sum = numbers[begin] + numbers[end];
            if (sum == target) {
                res[0] = begin + 1;
                res[1] = end + 1;
                return res;
            } else if (sum > target) {
                --end;
            } else {
                ++begin;
            }
        }
        return res;
    }
}
