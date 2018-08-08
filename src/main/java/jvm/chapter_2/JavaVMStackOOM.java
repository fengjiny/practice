package jvm.chapter_2;


/**
 * -Xss2M
 */
public class JavaVMStackOOM {
    private void dongStop() {
        while (true){

        }
    }
    public void stackLeakByThread() {
        while (true) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    dongStop();
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
