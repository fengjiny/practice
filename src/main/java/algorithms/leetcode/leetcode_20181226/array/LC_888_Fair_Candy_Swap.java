package algorithms.leetcode.leetcode_20181226.array;

import java.util.HashSet;

public class LC_888_Fair_Candy_Swap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        HashSet<Integer> set = new HashSet();
        for (int a : A) {
            sumA += a;
            set.add(a);
        }
        for (int b : B) {
            sumB += b;
        }
        int dif = (sumA - sumB) / 2;
        for (int b : B) {
            if (set.contains(b + dif)) {
                return new int[]{b + dif, b};
            }
        }
        return new int[0];
    }
}
