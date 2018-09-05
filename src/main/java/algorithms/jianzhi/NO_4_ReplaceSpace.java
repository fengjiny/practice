package algorithms.jianzhi;

public class NO_4_ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                sb.append("%");
                sb.append("2");
                sb.append("0");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return new String(sb);
    }
}

