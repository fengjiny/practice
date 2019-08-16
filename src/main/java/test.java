import algorithms.Utils;

import java.util.*;

public class test {
    public static void main(String[] args) {
//        int[] nums = {2,1,3,4,5,9,8,7};
//        qsort(nums, 0, nums.length - 1);
//        for (int i : nums) {
//            System.out.print(i);
//        }
//        System.out.println();
//
//
//        double d = 123.111;
//        System.out.println(d);
//        long l = Math.round(d);
//        System.out.println(l);
//

//        Map<String, String > map = new HashMap();
//        map.put("a", "a");
//        map.put("b", "b");
//        map.put("c", "c");
//        String str = map.get("a");
//        map.remove("a");
//        System.out.println(str);
//        System.out.println(map);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.set(0, 6);
        System.out.println(list);
//        list.add(9);
//        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(9);
        System.out.println(list2);

    }
    private static void amount(double htPrice) {
        int ht = 10283;
        double sum = ht * htPrice + 2366;
        System.out.println(sum);
    }
    private static void qsort(int[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            qsort(nums, p, q - 1);
            qsort(nums, q + 1, r);
        }
    }
    private static int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (nums[j] < x) {
                ++i;
                swap(nums, i,j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
