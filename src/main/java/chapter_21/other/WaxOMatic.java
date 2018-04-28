package chapter_21.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        Thread.sleep(5000);
        exec.shutdownNow();
    }
}

class Car {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn =false;
        notifyAll();
    }

    public synchronized void waitForBuffering() throws InterruptedException {
        while(waxOn == true)
            wait();
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car car) {
        this.car = car;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("Wax On! ");
                Thread.sleep(200);
                car.waxed();
                car.waitForBuffering();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax off!");
                Thread.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}