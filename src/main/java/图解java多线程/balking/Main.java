package 图解java多线程.balking;

public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(emtpy)");
        new ChangerThread("ChangerTrhead", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
