package algorithms;

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2};
        int index = new BinarySearch().binarySearch(nums, 1);
        System.out.println(index);
        int index2 = new BinarySearch().binarySearch(nums, 3);
        System.out.println(index2);
    }
}
