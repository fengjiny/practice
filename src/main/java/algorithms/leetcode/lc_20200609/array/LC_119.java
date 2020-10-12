package algorithms.leetcode.lc_20200609.array;

import java.util.ArrayList;
import java.util.List;

public class LC_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        while (rowIndex-- >= 0) {
            list.add(1);
            for (int i = list.size() - 2; i > 0; --i) {
                list.set(i, list.get(i) + list.get(i - 1));
            }
        }
        return list;
    }
}
