package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyInstance {
    private static volatile MyInstance instance;

    private MyInstance() {

    }

    public static MyInstance getInstance() {
        if (null == instance) {
            synchronized (MyInstance.class) {
                if (null == instance) {
                    instance = new MyInstance();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(MyInstance.getInstance().hashCode());
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(MyInstance.getInstance().hashCode());
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(MyInstance.getInstance().hashCode());
            }
        });
    }
}
