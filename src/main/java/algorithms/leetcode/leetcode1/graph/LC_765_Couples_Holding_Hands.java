package algorithms.leetcode.leetcode1.graph;

public class LC_765_Couples_Holding_Hands {
    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3, 5, 6, 7, 4};
        System.out.println(minSwapsCouples(row));
    }



    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            int dest;
            if ((row[i] & 1) == 0) dest = row[i] + 1;
            else dest = row[i] - 1;
            if (row[i + 1] == dest) continue;
            ++ans;
            for (int j = i + 2; j < n; ++j) {
                if (row[j] == dest) {
                    swap(row, i + 1, j);
                    break;
                }
            }
        }
        return ans;

    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
