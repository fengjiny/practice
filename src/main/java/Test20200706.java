import java.util.HashMap;
import java.util.Map;

public class Test20200706 {
    public int solution(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int[] count = new int[256];
        int flag = 0;
        for (char c : pc) {
            count[c]++;
        }
        int i = 0;
        int pLength = pc.length;
        for (; i < pLength; ++i) {
            if (count[sc[i]]-- <= 0) {
                flag++;
            }
        }
        for (; i < sc.length; ++i) {
            if (flag == 0) {
                return i - pLength;
            }
            if (count[sc[i]]-- <= 0) {
                flag++;
            }
            if (count[sc[i - pLength]]++ < 0) {
                flag--;
            }
        }
        return flag == 0? i - pLength : -1;
    }

    public static void main(String[] args) {
        String s = "asdasrfghs";
        String p = "adsr";
        int index = new Test20200706().solution(s, p);
        System.out.printf(String.valueOf(index));
    }
}
