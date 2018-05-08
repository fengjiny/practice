package tj4.chapter_21.exersice;

import org.omg.CORBA.PUBLIC_MEMBER;

class SynTest1 {
    public void f1() {
        synchronized (this) {
            for (int i = 0; i < 5; ++i) {
                System.out.println("f1()");
                Thread.yield();
            }
        }
    }

    public void g1() {
        synchronized (this) {
            for (int i = 0; i < 5; ++i) {
                System.out.println("g1()");
                Thread.yield();
            }
        }
    }

    public void h1() {
        synchronized (this) {
            for (int i = 0; i < 5; ++i) {
                System.out.println("h1()");
                Thread.yield();
            }
        }
    }
}

class SynTest2 {
    private Object synObject1 = new Object();
    private Object synObject2 = new Object();
    private Object synObject3 = new Object();
    public void f2() {
        synchronized (synObject1) {
            for (int i = 0; i < 5; ++i) {
                System.out.println("f2()");
                Thread.yield();
            }
        }
    }

    public void g2() {
        synchronized (synObject2) {
            for (int i = 0; i < 5; ++i) {
                System.out.println("g2()");
                Thread.yield();
            }
        }
    }

    public void h2() {
        synchronized (synObject3) {
            for (int i = 0; i < 5; ++i) {
                System.out.println("h2()");
                Thread.yield();
            }
        }
    }
}


public class Exercise_15{
    public static void main(String[] args) {
        final SynTest1 st1 = new SynTest1();
        final SynTest2 st2 = new SynTest2();
        new Thread() {
            @Override
            public void run() {
                st1.f1();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                st1.g1();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                st1.h1();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                st2.f2();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                st2.g2();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                st2.h2();
            }
        }.start();
    }
}
