package test;

public class TestClass {
    private int i;

    public int inc(){
        return ++i;
    }

    public static void main(String[] args) {
        int r = 100;
        for (int i = -r; i < r; ++i) {
            for (int j = -r; j < r; ++j) {
                if ((4*i + 4*j + i*j) == 45) {
                    System.out.println("i: " + i);
                    System.out.println("j: " +j);

                    System.out.println(i + j);
                }
            }
        }
    }
}
