package demo.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        AbstractTest abstractTest1 = new AbstractChild();
//
//        AbstractTest abstractTest2 = new AbstractChild();
//
//        InterfaceTest interfaceTest = new InterfaceChild();

        CountTest countTest = new CountTest();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; ++i) {
            executor.execute(new Task(countTest));
        }
        executor.shutdown();
//        for (int i = 0; i < 500; ++i) {
//            System.out.println(countTest.get(i));
//        }
        System.out.println(countTest.get());
    }
}
