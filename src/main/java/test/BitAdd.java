package test;

/**
 * 两个整数相加，用位运算
 */
public class BitAdd {

    public int add(int a, int b) {
        while (b != 0) {
            int xor = a ^ b;
            b = (a & b) << 1;
            a = xor;
        }
        return a;
    }

    public static void main(String[] args) {
        //11, 1001
        int a = 3, b = 9;
        System.out.println(new BitAdd().add(a, b));
    }
}
