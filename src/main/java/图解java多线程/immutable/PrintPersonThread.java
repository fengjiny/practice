package 图解java多线程.immutable;

public class PrintPersonThread extends Thread{
    private Person perSon;
    public PrintPersonThread(Person perSon) {
        this.perSon = perSon;
    }
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "prints" + perSon);
        }
    }
}
