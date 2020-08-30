package book.jvm.chapter_2;

public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;
    
    private byte[] bigSize = new byte[2* _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objb = new ReferenceCountingGC();
        objA.instance = objb;
        objb.instance = objA;

        objA = null;
        objb = null;
        System.gc();
    }

    public static void main(String[] args) {
//
    }
}
