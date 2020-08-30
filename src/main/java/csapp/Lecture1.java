package csapp;

public class Lecture1 {

    private void copyij(int[][] a, int[][] b) {
        for (int i = 0; i < a[0].length; ++i) {
            for (int j = 0; j < a.length; ++j) {
                a[i][j] = b[i][j];
            }
        }
    }

    private void copyji(int[][] a, int[][] b) {
        for (int j = 0; j < a.length; ++j) {
            for (int i = 0; i < a[0].length; ++i) {
                a[i][j] = b[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[2048][2048];
        int[][] b = new int[2048][2048];
        Lecture1 lecture1 = new Lecture1();

        long ijStart = System.currentTimeMillis();
        lecture1.copyij(a,b);
        long ijend = System.currentTimeMillis();
        System.out.println("copyij use time : " + (ijend - ijStart));

        long jiStart = System.currentTimeMillis();
        lecture1.copyji(a,b);
        long jiend = System.currentTimeMillis();
        System.out.println("copyji use time : "+(jiend - jiStart));




    }
}
