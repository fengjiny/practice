package algorithms.leetcode_20181226.array;

public class LC_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid;
        }
        if (nums[i] != target)
            return res;
        else
            res[0] = i;
        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (nums[mid] > target)
                j = mid - 1;
            else
                i = mid;
        }
        res[1] = j;
        return res;
    }
}
