package algorithms.leetcode.array;

public class LC_167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) return res;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (v > target) {
                --right;
            } else {
                ++left;
            }
        }
        return res;
    }
}
