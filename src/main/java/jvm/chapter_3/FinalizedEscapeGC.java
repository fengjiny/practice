package jvm.chapter_3;

public class FinalizedEscapeGC {
    public static FinalizedEscapeGC SAVE_HOOK = null;
    public void isAlive(){
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        FinalizedEscapeGC.SAVE_HOOK = this;
        System.out.println("finalized()");
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizedEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
