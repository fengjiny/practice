package book.图解java多线程.example.worker_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        Channel channel = new Channel(5);
//        channel.startWorkers();
//        new ClientThread("Alice", channel).start();
//        new ClientThread("Bobby", channel).start();
//        new ClientThread("Chris", channel).start();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            new ClientThread("Alice", executorService).start();
            new ClientThread("Bobby", executorService).start();
            new ClientThread("Chris", executorService).start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }finally {
            executorService.shutdown();
        }
    }
}
