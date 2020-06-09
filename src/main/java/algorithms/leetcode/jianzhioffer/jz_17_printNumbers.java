package algorithms.leetcode.jianzhioffer;

public class jz_17_printNumbers {
    public int[] printNumbers(int n) {
        double length = Math.pow(10, n) - 1;
        int[] res = new int[new Double(length).intValue()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = i;
        }
        return res;
    }
}
