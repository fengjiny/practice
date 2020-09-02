package test;

public class Test20200902 {

    public int find(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int index = mid;
                while(index >= 0 && nums[index] == target) {
                    index--;
                }
                return index + 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,5,5,6,7,8};
        int index = new Test20200902().find(nums, 5);
        System.out.println(index);

        int index2 = new Test20200902().find(nums, 0);
        System.out.println(index2);
    }
}
