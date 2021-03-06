package book.jvm.chapter_2;

import java.util.ArrayList;
import java.util.List;


/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject { }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
            System.out.println("list size is " + list.size());
        }
    }
}
