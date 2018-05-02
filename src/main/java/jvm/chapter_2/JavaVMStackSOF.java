package jvm.chapter_2;

/**
 * -Xss160k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() throws InterruptedException {
        stackLength++;
//        Thread.sleep(10);
//        System.out.println("Current stack length is " + stackLength);
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("  Stack length: " + oom.stackLength);
            throw e;
        }
    }
}
