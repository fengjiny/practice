package tj4.chapter_21.exersice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 练习9
 * 修改SimplePriorities.java,使得定制ThreadFactory可以设置线程的优先级
 */
public class Exercise_9 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
        for (int i = 0; i < 5; ++i) {
            exec.execute(new SimplePriorities());
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));
        for (int i = 0; i < 5; ++i) {
            exec.execute(new SimplePriorities());
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        Thread.yield();
        exec.shutdown();
    }
}

class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;
    public SimplePriorities(){}
    public SimplePriorities(int priority) {
        this.priority = priority;
    }
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 100000; ++i) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
}

class PriorityThreadFactory implements ThreadFactory {
    private final int priority;

    PriorityThreadFactory(int priority) {
        this.priority = priority;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread();
        t.setPriority(priority);
        return t;
    }
}
