package book.图解java多线程.example.two_phase_termination;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable {
    private final CountDownLatch downLatch;
    private final int context;
    private static final Random random = new Random(314159);

    public MyTask(CountDownLatch downLatch, int context) {
        this.downLatch = downLatch;
        this.context = context;
    }

    @Override
    public void run() {
        doTask();
        downLatch.countDown();
    }

    protected void doTask() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": MyTsk: BEGIN: context = " + context);
        try {
            Thread.sleep(random.nextInt(1000));
        }catch (InterruptedException e) {

        }finally {
            System.out.println(name + ":MyTask:END: context = " + context);
        }
    }
}
