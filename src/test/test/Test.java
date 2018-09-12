package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        ScheduledFuture future = executor.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("60 seconds later");
                    }
                }, 60, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
