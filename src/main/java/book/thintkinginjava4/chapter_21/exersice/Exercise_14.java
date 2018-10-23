package book.thintkinginjava4.chapter_21.exersice;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise_14 implements Runnable{
    private AtomicInteger ai = new AtomicInteger();


    @Override
    public void run() {
        while (true) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Current timeTask number is "+ ai.getAndAdd(1));
                }
            }, ai.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exercise_14 ex = new Exercise_14();
//        for (int i = 0; i < 10; ++i) {
//            exec.execute(ex);
//        }
        exec.execute(ex);
        exec.shutdown();
        Thread.sleep(10000);
        System.out.println("TimerTask count is : " + ex.ai.get());
    }
}
