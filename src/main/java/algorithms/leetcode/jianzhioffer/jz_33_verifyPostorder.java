package algorithms.leetcode.jianzhioffer;

public class jz_33_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int l = i;
        while (postorder[l] < postorder[j]) {
            ++l;
        }
        int m = l;
        while (postorder[l] > postorder[j]) {
            ++l;
        }
        return l == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
