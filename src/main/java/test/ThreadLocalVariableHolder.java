package test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> variableHolder = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static int getValue() {
        return variableHolder.get();
    }

    public static void remove() {
        variableHolder.remove();
    }

    public static void increment() {
        variableHolder.set(variableHolder.get() + 1);
    }
    private static void clear() {
        variableHolder.set(0);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                long threadId = Thread.currentThread().getId();
                int before = getValue();
                increment();
                int after = getValue();
                clear();
                System.out.println("ThreadId :" + threadId + ", before: " + before + ", after: " + after);
            });
        }

        executor.shutdown();
    }
}