package algorithms.leetcode.leetcode_20181226.array;

public class LC_985_Sum_of_Even_Numbers_After_Queries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0];
            int index = queries[i][1];
            A[index] += val;
            for (int n : A) {
                if (n % 2 == 0) {
                    res[i] += n;
                }
            }
        }
        return res;
    }
}
