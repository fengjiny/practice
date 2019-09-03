package algorithms.leetcode.leetcode1.array;

public class LC_27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] != val) {
                nums[begin++] = nums[i];
            }
        }
        return begin;
    }
}
