package interview;

public class Test {

    public int searchInRotateArray(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == val) return mid;
            if (nums[mid] > nums[left]) {
                if (val > nums[left] && val < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (val > nums[mid] && val < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
