package algorithms.leetcode.jianzhioffer;

public class JZ_65_add {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 101;
        int b = 10;
        int c = a/b;
        System.out.println(c);
    }
}
