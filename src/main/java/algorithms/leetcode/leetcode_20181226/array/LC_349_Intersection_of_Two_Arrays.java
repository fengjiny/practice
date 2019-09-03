package algorithms.leetcode.leetcode_20181226.array;

import java.util.HashSet;
import java.util.Set;

public class LC_349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (set.contains(n)) {
                intersect.add(n);
            }
        }
        int i = 0;
        int[] res = new int[intersect.size()];
        for (int n : intersect) {
            res[i++] = n;
        }
        return res;
    }
}
