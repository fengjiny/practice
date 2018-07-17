package algorithms.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        hashMapTest();
     }

    private static void test1() {
        int a = 1, b = -2;
        System.out.println(Integer.toBinaryString(a << 1));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        for (int i = 0; i < 32; ++i) {
            System.out.println(Integer.toBinaryString(b >>> i));
        }
    }
    private static void hashMapTest() {
        Map<Integer, Integer> map  = new HashMap<>();
        map.put(1,1);
    }

    private static void strReplace(){

    }
}
