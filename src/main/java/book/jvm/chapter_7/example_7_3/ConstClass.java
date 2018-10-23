package book.jvm.chapter_7.example_7_3;

public class ConstClass {
    static {
        System.out.println("ConstClass init !");
    }
    public static final String HELLOWORLD = "hello world";
}
