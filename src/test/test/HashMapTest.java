package test;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Hstest hstest = new Hstest();
        for (int i = 0; i < 200; ++i) {
            executor.execute(hstest);
        }
        executor.shutdown();
    }
}

class Hstest implements Runnable {
    static HashMap<Integer, Integer> map = new HashMap<>(2);
    static AtomicInteger ai = new AtomicInteger();
    @Override
    public void run() {
        while (ai.get() < 10000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
            System.out.println(ai);
//            System.out.println(map);
        }
    }
}
