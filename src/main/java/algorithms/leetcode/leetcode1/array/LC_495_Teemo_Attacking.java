package algorithms.leetcode.leetcode1.array;

public class LC_495_Teemo_Attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int begin = timeSeries[0], tolal = 0;
        for (int t : timeSeries) {
            tolal = tolal + (t < begin + duration ? t - begin : duration);
            begin = t;
        }
        return tolal + duration;
    }
}
