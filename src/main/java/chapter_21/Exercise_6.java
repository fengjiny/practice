package chapter_21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 练习6
 * 创建一个任务，它将睡眠1至10秒之间的随机数量的时间，然后显示它的睡眠时间并退出。
 * 创建并运行一定数量的这种任务。
 */
public class Exercise_6 implements Runnable{
    private int sleepTime;
    Exercise_6(int sleepTime) {
        this.sleepTime = sleepTime;
    }
    public void run() {
        try {
            Thread.sleep(sleepTime);
            System.out.println("The sleep time is " + sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; ++i) {
            exec.execute(new Exercise_6(new Random().nextInt(10) * 1000));
        }
        exec.shutdown();
    }
}
