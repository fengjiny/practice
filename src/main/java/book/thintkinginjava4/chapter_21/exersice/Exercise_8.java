package book.thintkinginjava4.chapter_21.exersice;


import java.util.concurrent.TimeUnit;

/**
 * 练习8
 * 把SimpleThread.java中所有线程修改成后台线程，并验证一旦main()退出，
 * 程序立刻终止。
 */
public class Exercise_8 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; ++i) {
            SimpleThread st = new SimpleThread();
        }
        TimeUnit. MILLISECONDS.sleep(10000);

    }
}

class SimpleThread extends Thread {
    private  int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread(){
        //store the thread name;
        super(Integer.toString(++threadCount));
        start();
    }
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this + ": " + this.isDaemon());
            if (--countDown == 0) {
                return;
            }
        }
    }
}

