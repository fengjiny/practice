package book.图解java多线程.example.read_write_lock;

public class ReaderThread extends Thread {
    private final Data data;
    public ReaderThread(Data data) {
        this.data = data;
    }
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " +
                        String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {

        }
    }
}
