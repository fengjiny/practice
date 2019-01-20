package MJ_20190117;

import java.lang.reflect.Field;

public class SwapInteger {
    public static void main(String[] args) throws Exception {
        Integer a = 1, b = 2;
        System.out.println("before swap , a=" + a + ", b=" + b);
        swap3(a, b);
        System.out.println("after swap , a=" + a + ", b=" + b);

        Integer c1 = 1, c2 = 1;
        System.out.println(c1 == c2);
    }

    //Integer缓存 -128 ~ 127之间, 自动装箱和拆箱
    private static void swap1(Integer a, Integer b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    //通过反射去修改private final 变量
    private static void swap2(Integer a, Integer b) throws Exception{
        Field filed = Integer.class.getDeclaredField("value");
        filed.setAccessible(true);
        int tmp = a.intValue();     //tmp指向的是a的地址
        filed.set(a, b.intValue());
        filed.set(b, tmp);
    }

    private static void swap3(Integer a, Integer b) throws Exception{
        Field filed = Integer.class.getDeclaredField("value");
        filed.setAccessible(true);
        Integer tmp = new Integer(a.intValue());
        filed.set(a, b.intValue());
        filed.set(b, tmp);
    }
}
