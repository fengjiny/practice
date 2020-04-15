package algorithms.leetcode.jianzhioffer;

public class jz_05_replaceSpace {
    public String replaceSpace(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                ++count;
            }
        }
        char[] res = new char[s.length() + count * 2];
        for (int j = chars.length - 1, i = res.length - 1; j >= 0; --j, --i) {
            if (chars[j] == ' ') {
                res[i] = '0';
                res[--i] = '2';
                res[--i] = '%';
            } else {
                res[i] = chars[j];
            }
        }
        return new String(res);
    }

    public String replaceSpace2(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new jz_05_replaceSpace().replaceSpace2(s));
    }
}
