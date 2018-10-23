package book.thintkinginjava4.chapter_21.other;

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
//        if (args.length != 1) {
//            System.out.println("usage: java InterruptingIdiom delay-in-ms");
//            System.exit(1);
//        }
        Thread t = new Thread(new Blocked3());
        t.start();
        Thread.sleep(3500);
        t.interrupt();
    }

}

class NeedsCleanup {
    private final int id;
    public NeedsCleanup(int ident) {
        this.id = ident;
        System.out.println("NeedsCleanup "+ id);
    }
    public void cleanup() {
        System.out.println("Cleaning up " + id);
    }
}
class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    public void run() {
        try {
            while(!Thread.interrupted()) {
                NeedsCleanup n1 = new NeedsCleanup(1);

                try {
                    System.out.println("Sleeping");
                    Thread.sleep(1000);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 1; i < 250000; ++i) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }
    }
}
