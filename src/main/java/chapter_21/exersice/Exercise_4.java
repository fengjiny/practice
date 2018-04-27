package chapter_21.exersice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 练习4
 * 使用本节展示的各种不同类型的执行器重复练习2
 */
public class Exercise_4 {
    public static void main(String[] args) {
        ExecutorService exec1 = Executors.newCachedThreadPool();
        for (int i = 1; i < 20; ++i) {
            exec1.execute(new Exercise_2(i));
        }
        exec1.shutdown();

        ExecutorService exec2 = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 20; ++i) {
            exec2.execute(new Exercise_2(i));
        }
        exec2.shutdown();

        ExecutorService exec3 = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 20; ++i) {
            exec3.execute(new Exercise_2(i));
        }
        exec3.shutdown();
    }
}
