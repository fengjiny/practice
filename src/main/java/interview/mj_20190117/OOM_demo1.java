package interview.mj_20190117;

public class OOM_demo1 {

    private static int count = 0;
    public static void a() throws InterruptedException {
        Thread.sleep(1000);
        Byte[] bytes = new Byte[1024 * 1024 * 800];

        ++count;
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException{
        while (true) {
            a();
        }
    }
}
