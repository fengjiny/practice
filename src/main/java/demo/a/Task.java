package demo.a;

public class Task implements Runnable {
    private CountTest countTest;
    public Task(CountTest countTest) {
        this.countTest = countTest;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            countTest.increase();
//            System.out.println(countTest.get());
        }
    }
}
