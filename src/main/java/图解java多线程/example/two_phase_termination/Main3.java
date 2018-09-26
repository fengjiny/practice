package 图解java多线程.example.two_phase_termination;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3 {
    private static final int THREADS = 3;

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        //屏障被解除时的操作
        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Action");
            }
        };

        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);

        CountDownLatch downLatch = new CountDownLatch(THREADS);

        try {
            for (int i = 0; i < THREADS; ++i) {
                service.execute(new MyCyclicBarrierTask(phaseBarrier, downLatch, i));
            }
            System.out.println("AWAIT");
            downLatch.await();
        } catch (InterruptedException e) {

        }finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
