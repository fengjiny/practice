package algorithms.jianzhi;

public class JumpFloor {
    public int JumpFloor(int target) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < target; ++i) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
