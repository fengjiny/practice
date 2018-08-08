package algorithms.leetcode.sort;

import java.util.HashSet;
import java.util.Set;

public class LC_349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                intersect.add(i);
            }
        }
        int[] res = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            res[i++] = num;
        }
        return res;
    }
}
