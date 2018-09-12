package 图解java多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Counter counter = new Counter();
        for (int i = 0; i < 1999; ++i) {
            executor.execute(new Task1(counter));
        }
        Thread.sleep(1000);
        System.out.println("count is " + counter.getCount());
        executor.shutdown();
    }
}
