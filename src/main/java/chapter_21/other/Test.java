package chapter_21.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    //公共变量
    private static int count=0;
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; ++i) {
            exec.execute(new MyRunnable());
        }
        exec.shutdown();
    }
    //创建一个实现Runnable的类
    static class MyRunnable implements Runnable{
        public void run() {
            while(true){
                //锁住的是整个MyRunnable类
                synchronized(MyRunnable.class){
                    if(count>=1000){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+":count:"+(++count));
                    //测试时，线程更容易切换
                    Thread.yield();
                }

            }
        }

    }

}