package chapter_21;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 练习2
 * 遵循generic/Fibonacci.java的形式，创建一个任务，它可以产生由n个斐波那契数字
 * 组成的序列，其中n是通过任务的构造器而提供的。使用线程创建大量的这种任务并驱动它
 * 们。
 */
public class Exercise_2 implements Runnable{
    private int n;
    Exercise_2(int n) {
        this.n = n;
    }
    public void run() {
        Integer[] fibArray = new Integer[n];
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; ++i) {
            b = a + b;
            a = b - a;
            fibArray[i] = a;
        }
        System.out.println("sequence " + n + " is :" + Arrays.toString(fibArray));
    }
    public static void main(String[] args) {
        for (int i = 1; i < 20; ++i) {
            Thread t = new Thread(new Exercise_2(i));
            t.start();
        }
    }
}
