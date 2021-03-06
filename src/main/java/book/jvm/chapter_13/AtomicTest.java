package book.jvm.chapter_13;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger(0);
    public static void increase() throws InterruptedException {
        Thread.sleep(50);
        race.incrementAndGet();
        System.out.println(race.get());
    }
    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; ++i) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; ++i) {
                        try {
                            increase();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
            System.out.println(race);
        }
    }
}
