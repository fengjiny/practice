package thintkinginjava4.chapter_21.exersice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 练习5
 * 修改练习2，使得计算所有斐波那契数字的数值总和的
 * 任务成为 Callable。 创建多个任务并显示结果。
 *
 * 练习2:遵循generic/Fibonacci.java的形式，创建一个任务，
 * 它可以产生由n个斐波那契数字组成的序列，其中n是通过任务
 * 的构造器而提供的，使用线程创建大量这样的任务并驱动他们。
 */
public class Exercise_5 implements Callable<String> {
    private int n;
    Exercise_5(int n){
        this.n = n;
    }
    public String call() throws Exception {
        return sumOfFibnacci();
    }
    private String sumOfFibnacci(){
        int a = 0;
        int b = 1;
        int[] fib = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            b = a + b;
            a = b - a;
            fib[i] = a;
            sum += a;
        }
        return "The fibonacci sequence is : " + Arrays.toString(fib) + " , and the sum of sequence is : " + sum;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 1; i < 20; ++i) {
            list.add(exec.submit(new Exercise_5(i)));
        }
        for (Future<String> fs : list) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}
