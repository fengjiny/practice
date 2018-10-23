package book.thintkinginjava4.chapter_21.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue() {
        return i;
    }
    private synchronized void evenInrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenInrement();
            System.out.println(getValue());
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int value = at.getValue();
            if (value % 2 != 0){
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
