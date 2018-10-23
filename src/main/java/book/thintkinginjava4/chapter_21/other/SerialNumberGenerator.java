package book.thintkinginjava4.chapter_21.other;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public synchronized static int nextSerialNumber() {
        System.out.println(serialNumber);
        return serialNumber++;
    }
}
