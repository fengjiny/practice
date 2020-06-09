package algorithms.leetcode.jianzhioffer;

public class jz_11_minArray {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        int mid = l;
        while (l < r && numbers[l] >= numbers[r]) {
            if (r - l == 1) {
                return numbers[r];
            }
            mid = (l + r) / 2;
            if (numbers[l] == numbers[r] && numbers[l] == numbers[mid]) {
                return findMin(numbers, l, r);
            } else if (numbers[mid] >= numbers[l]) {
                l = mid;
            } else if (numbers[mid] <= numbers[r]) {
                r = mid;
            }
        }
        return numbers[mid];
    }

    private int findMin(int[] nums, int begin, int end) {
        int min = nums[begin];
        for (int i = begin + 1; i <= end; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
