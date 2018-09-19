package demo.a;


public class CountTest {
    private int count;
    public synchronized void increase() {
        ++count;
        System.out.println(count);
    }

    public synchronized int get() {
        return count;
    }
}
