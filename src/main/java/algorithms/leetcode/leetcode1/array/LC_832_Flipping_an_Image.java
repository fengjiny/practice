package algorithms.leetcode.leetcode1.array;

public class LC_832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] nums : A) {
            reverse(nums, 0, nums.length - 1);
            invert(nums);
        }
        return A;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            ++i;
            --j;
        }
    }
    private void invert(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            nums[i] ^= 1;
        }
    }

    public int[][] flipAndInvertImage_solution2(int[][] A) {
        int n = A.length;
        for (int[] row : A) {
            for (int i = 0; i * 2 < n; ++i) {
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
            }
        }
        return A;
    }
}
