package algorithms.jianzhi;

public class NO_62_lastRemaining {
    public int lastRemaining(int n, int m) {
        int index = 0;
        for (int i = 2; i <= n; ++i) {
            index = (index + m) % i;
        }
        return index;
    }

    public static void main(String[] args) {
        int index = new NO_62_lastRemaining().lastRemaining(5, 3);
        System.out.println(index);
    }
}
