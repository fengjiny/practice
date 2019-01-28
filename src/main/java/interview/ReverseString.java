package algorithms.interview;

public class ReverseString {
    public static void main(String[] args) {
        String s = "abcdefgh";
        s = reverseString(s.toCharArray(), 5);
        System.out.println(s);
    }


    public static String reverseString(char[] ch, int k) {
        int n = ch.length;
        k = k % n;
        reverse(ch, 0, k - 1);
        reverse(ch, k, n - 1);
        reverse(ch, 0, n - 1);
        return new String(ch);
    }
    private static void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char tmp = ch[i];;
            ch[i++] = ch[j];
            ch[j--] = tmp;
        }
    }
}
