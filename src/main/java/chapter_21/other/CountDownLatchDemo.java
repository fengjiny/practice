package chapter_21.other;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskPortion implements Runnable {
    private  static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;
    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void doWork() throws InterruptedException {
        Thread.sleep(rand.nextInt(2000));
        System.out.println(this + " completed");
    }

    public String toString() {
        return String.format("%1$-3d ", id);
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {

        }
    }
}

class WaitingTask implements Runnable {
    private static int couter = 0;
    private final int id = couter++;
    private final CountDownLatch latch;
    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}




public class CountDownLatchDemo {
    static final int Size = 100;
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(Size);
        for (int i = 0; i < 10; ++i) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < Size; ++i) {
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        Thread.sleep(5000);
        exec.shutdownNow();
    }
}
