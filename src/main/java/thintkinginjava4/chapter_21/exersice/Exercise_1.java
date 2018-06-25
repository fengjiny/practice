package thintkinginjava4.chapter_21.exersice;


/**
 * 练习1
 * 实现一个Runnable。在run()内部打印一个消息，然后调用yield()。重复
 * 这个操作三次，然后从run()中返回。在构造器中放置一条启动消息，并且
 * 放置一条在任务终止时的关闭消息。使用线程创建大量这种任务并驱动它们。
 */

public class Exercise_1 implements  Runnable {
    Exercise_1() {
        System.out.println("Start Exercise_1");
    }

    public void run() {
        for (int i = 0; i < 3; ++i) {
            System.out.print("i = " + i + ",");
            Thread.yield();
        }
        System.out.println("End Exercise_1");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            Thread t = new Thread(new Exercise_1());
            t.start();
        }
    }
}


