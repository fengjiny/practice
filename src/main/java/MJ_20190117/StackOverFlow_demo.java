package MJ_20190117;

public class StackOverFlow_demo {
    private static int count = 0;
    public static void A() {
        ++count;
        System.out.println(count);
        A();
    }

    public static void main(String[] args) {
        A();
    }
}
