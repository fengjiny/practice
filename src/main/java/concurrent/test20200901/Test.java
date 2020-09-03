package concurrent.test20200901;

import java.util.concurrent.*;

public class Test {


    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 5;
        long keepAliveTime = 100;
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(5);
        ExecutorService executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, queue);

        Runnable runnable = () -> {
            System.out.println(queue.size());
        };

        for (int i = 0; i < 20; ++i) {
            executor.execute(runnable);
        }
    }
}
