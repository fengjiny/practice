package algorithms.leetcode.leetcode_20181226.math;

public class LC_204_Count_Primes {
    public int countPrimes(int n) {
        boolean[]  notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (notPrime[i] == false) {
                ++count;
                for (int j = 2; i * j < n; ++j) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
