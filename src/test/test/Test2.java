package test;

public class Test2 {
    public static void main(String[] args) {
        B b = new B();
        b.func();

        A a = new B();
        a.func2();
    }
}

class A {
    public A () {
        System.out.println("construct A");
    }

    public void func1() {
        System.out.println("A class func1");
    }

    public void func2() {
        System.out.println("A class func2");
    }
}

class B extends A {
    public B () {
        System.out.println("construct B");
    }

    public void func() {
        func2();
    }

    @Override
    public void func2() {
        System.out.println("B class func2");
    }
}