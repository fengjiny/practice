package algorithms.leetcode_20181226.array;

public class LC_11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int area = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int width = j - i;
            int h = height[i] <= height[j] ? height[i++] : height[j--];
            int curArea = width * h;
            area = Math.max(area, curArea);
        }
        return area;
    }
}
