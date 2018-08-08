package thintkinginjava4.chapter_21.exersice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/** 练习10
 * 按照ThreadMethod类修改练习5，使得runTask()方法接受一个参数，表示
 * 要计算总和的斐波那契数字的数量，并且，每次调用runTask()时，它将返回
 * 对submit()的调用所产生的Future。
 *
 */


public class Exercise_10 {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        List<Integer> res = new ArrayList<Integer>();
        try {
            for (int i = 1; i <= 10; ++i) {
                res.add(fib.runTask(i).get());
            }
            for (int i = 0; i < res.size(); ++i){
                System.out.println("The sum of first " + i + " Fibonacci numbers = " + res.get(i));
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            fib.exec.shutdown();
        }
    }
}

class Fibonacci implements Callable<Integer> {
    private volatile int n = 0;
    ExecutorService exec = Executors.newCachedThreadPool();

    @Override
    public Integer call() throws Exception {
        int a = 0;
        int b = 1;
        int[] fib = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i){
            b = a + b;
            a = b - a;
            fib[i] = a;
            sum += a;
        }
        System.out.println("while n = " + n + ", The fibonacci sequence is : " + Arrays.toString(fib) + " , and the sum of sequence is : " + sum);
        return sum;
    }
    public synchronized Future<Integer> runTask(Integer n) {
        this.n = n;
        return exec.submit(this);
    }
}
