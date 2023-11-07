package interview.ctci.arraysandstrings.ZeroMatrix;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write an algorithm such that if an element in an MxN matrix its entire row and column are set to 0
 */
public class ZeroMatrix {
    public static int[][] zeroMatrix(int[][] matrix) {
        // there's a way to do it using the original matrix, but this is O(n*m) time and O(n+m) space

        if (matrix.length == 0) return matrix;

        var rowsToZero = new boolean[matrix.length];
        var colsToZero = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero[i] = true;
                    colsToZero[j] = true;
                }
            }
        }

        for (int i = 0; i < rowsToZero.length; i++) {
            if (!rowsToZero[i]) continue;
            Arrays.fill(matrix[i], 0);
        }

        for (int i = 0; i < colsToZero.length; i++) {
            if (!colsToZero[i]) continue;
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }

        return matrix;
    }
}
