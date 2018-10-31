package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.*;


public class Test {
    public static void main(String[] args) {
        test2();
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


    public static void test2() {
        Hashtable hashtable = new Hashtable();
        HashMap hashMap = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        TreeMap treeMap = new TreeMap();

        hashtable.put(null, null);
        hashMap.put(null, null);
        concurrentHashMap.put(null, null);
        treeMap.put(null, null);
    }
}
