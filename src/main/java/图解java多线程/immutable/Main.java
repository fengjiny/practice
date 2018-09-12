package 图解java多线程.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main1(String[] args) {
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
