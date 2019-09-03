package algorithms.leetcode.leetcode1.array;

public class LC_278_First_Bad_Version {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    private boolean isBadVersion(int version) {
        return false;
    }
}
