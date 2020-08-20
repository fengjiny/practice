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
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(2);
        Integer i3 = new Integer(1);
        System.out.println(i1 == i2);
        System.out.println(i1.intValue() ==  i3);

    }
}
