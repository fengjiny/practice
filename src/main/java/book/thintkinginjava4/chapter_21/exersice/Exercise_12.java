package book.thintkinginjava4.chapter_21.exersice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Atomicity implements Runnable{
    private int i = 0;

    public synchronized int getValue(){
        return i;
    }
    public synchronized void evenInrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getValue());
            evenInrement();
        }
    }
}


public class Exercise_12 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Atomicity at = new Atomicity();
        exec.execute(at);
        while (true) {
            int value = at.getValue();
            if (value % 2 != 0) {
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
