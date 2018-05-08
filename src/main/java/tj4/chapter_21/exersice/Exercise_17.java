package tj4.chapter_21.exersice;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RadCount {
    private int count = 0;
    public synchronized int increment() {
        return count++;
    }
    public synchronized int value() {
        return count;
    }
}

class Sensor implements Runnable {
    private static RadCount count = new RadCount();
    private static List<Sensor> sensors = new ArrayList<Sensor>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;
    public static void cancel() {
        canceled = true;
    }
    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping " + this);
    }
    public synchronized int getValue() {
        return number;
    }
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumSensors() {
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.getValue();
        }
        return sum;
    }
}

public class Exercise_17 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; ++i) {
            exec.execute(new Sensor(i));
        }
        Thread.sleep(4000);
        Sensor.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        System.out.println("Total: " + Sensor.getTotalCount());
        System.out.println("Sum of Sensors: " + Sensor.sumSensors());
    }
}
