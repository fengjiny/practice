package thintkinginjava4.chapter_21.other;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestAccumulator {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; ++i) {
            exec.execute(new Accumulator(i));
        }
        exec.shutdown();
    }

    static class Accumulator implements Runnable {
        private static int count;
        private final int id;

        public Accumulator(int id) {
            this.id = id;
        }

        public synchronized void increment() {
            ++count;
        }

        public synchronized int value() {
            return count;
        }

        public String toString() {
            return "Accumulator " + id + " Total: " + value();
        }

        public void run() {
            while (true) {
                synchronized (Accumulator.class) {
                    if(count >= 1000) break;
                    increment();
                    System.out.println(this);
                }
            }
        }


    }
}