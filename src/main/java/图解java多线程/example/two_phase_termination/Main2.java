package 图解java多线程.example.two_phase_termination;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    private static final int TASKS = 10;

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch downLatch = new CountDownLatch(TASKS);
        try {
            for (int i = 0; i < TASKS; ++i) {
                service.execute(new MyTask(downLatch,i));
            }
            System.out.println("AWAIT");

            downLatch.await();
        } catch (InterruptedException e) {

        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
