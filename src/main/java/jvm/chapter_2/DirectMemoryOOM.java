package jvm.chapter_2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;


/**
 * -Xmx20M-XX:MaxDirectMemorySize=10M
 * -XX:+PrintGCDetails 查看GC日志
 */
public class DirectMemoryOOM {
    private static final int _100MB = 100 * 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_100MB);
//            System.out.println("Have been allocate 1MB space!");
        }
    }
}
