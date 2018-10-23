package book.jvm.chapter_7.example_7_4;

public class Parent {
    public static int A = 1;
    static {
        A = 2;
    }
    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
