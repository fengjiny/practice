package tj4.chapter_21.exersice;

import java.util.concurrent.TimeUnit;

/**
 * 练习7
 * 在Daemons.java中使用不同的休眠时间，并观察结果。
 */
public class Exercise_7 {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println( "d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.MILLISECONDS.sleep(1);
    }

}
class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    public void run() {
        for (int i = 0; i < t.length; ++i) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn() " + i + " started, ");
        }
        for (int i = 0; i < t.length; ++i) {
            System.out.println("t[" + i + "],isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}