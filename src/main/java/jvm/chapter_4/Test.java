package jvm.chapter_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Test {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; ++i) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    /**
     * 线程死循环
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        }, "testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    static class SynAddRunable implements Runnable {
        int a, b;
        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        for (int i= 0; i < 100; ++i) {
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
        }
    }
}
