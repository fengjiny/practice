package book.图解java多线程;

public class Counter {
    private int count = 0;

    public synchronized void increase() {
        ++count;
    }
    public synchronized int getCount() {
        return count;
    }
}
