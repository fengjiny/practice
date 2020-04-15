package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.leetcode1.array.PrintArray;

import java.util.ArrayList;
import java.util.List;

public class jz_29_spiralOrder {
    List<Integer> list = new ArrayList<>();
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0 || matrix.length == 0) return new int[0];
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrix(matrix, columns, rows, start);
            ++start;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void printMatrix(int[][] matrix, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; ++i) {
            int num = matrix[start][i];
            list.add(num);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int num = matrix[i][endX];
                list.add(num);
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int num = matrix[endY][i];
                list.add(num);
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int num = matrix[i][start];
                list.add(num);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}};
        PrintArray.printArray(new jz_29_spiralOrder().spiralOrder(matrix));
    }
}
