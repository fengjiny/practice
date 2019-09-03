package algorithms.leetcode.leetcode_20181226;

public class GenarateClassName {
    public static void main(String[] args) {
        String origin = "220. Contains Duplicate III";
        String className = new GenarateClassName().generateName(origin);
        System.out.println(className);
    }
    private String generateName(String origin) {
        String tmp = origin.replaceAll("\\.", "").replaceAll(" ", "_").replaceAll("'", "");
        StringBuilder sb = new StringBuilder();
        sb.append("LC_");
        sb.append(tmp);
        return sb.toString();
    }
}
