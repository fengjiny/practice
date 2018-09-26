package thintkinginjava4.chapter_18.section_18_10;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

import static net.mindview.util.Print.*;

public class AvailaleCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while (it.hasNext()) {
            String csName = it.next();
            printnb(csName);
            Iterator aliases = charSets.get(csName).aliases().iterator();
            if (aliases.hasNext())
                printnb(": ");
            while (aliases.hasNext()) {
                printnb(aliases.hasNext());
                if (aliases.hasNext())
                    printnb(", ");
            }
            print();
        }
    }
}
