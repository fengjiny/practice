package test;

public class Book2 {
    public static void main(String[] args)
    {
        staticFunction();
    }

    static Book2 book = new Book2();

    static
    {
        System.out.println("书的静态代码块");
    }

    {
        System.out.println("书的普通代码块");
    }

    Book2()
    {
        System.out.println("书的构造方法");
        System.out.println("price=" + price +",amount=" + amount);
    }

    public static void staticFunction(){
        System.out.println("书的静态方法");
    }

    int price = 110;
    static int amount = 112;
}
