package algorithms.leetcode.leetcode1.top100;

public class LC_338_Counting_Bits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
         for (int i = 0; i <= num; ++i) {
             int count = countBit(i);
             res[i] = count;
         }
         return res;
    }
    private int countBit(int num) {
        int count = 0;
        while (num != 0) {
            ++count;
            num &= num - 1;
        }
        return count;
    }
}
