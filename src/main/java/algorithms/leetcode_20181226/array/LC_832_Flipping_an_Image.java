package algorithms.leetcode_20181226.array;

public class LC_832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A) {
            for (int i = 0; i * 2 < n; ++i) {
                if (row[i] == row[n - i - 1]) {
                    row[i] = row[n - i - 1] ^= 1;
                }
            }
        }
        return A;
    }
}
