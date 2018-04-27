package chapter_21;

import java.util.concurrent.*;

/**
 * 练习3
 * 使用本节展示的各种不同类型的执行器重复练习1.
 */
public class Exercise_3 {
    public static void main(String[] args) {
        ExecutorService exec1 = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; ++i) {
            exec1.execute(new Exercise_1());
        }
        exec1.shutdown();


        ExecutorService exec2 = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; ++i) {
            exec2.execute(new Exercise_1());
        }
        exec2.shutdown();

        ExecutorService exec3 = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; ++i) {
            exec3.execute(new Exercise_1());
        }
        exec3.shutdown();
    }
}


