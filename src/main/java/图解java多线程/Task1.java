package 图解java多线程;

public class Task1 implements Runnable{
    private Counter counter;

    public Task1(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        counter.increase();
        System.out.println(counter.getCount());
    }
}
