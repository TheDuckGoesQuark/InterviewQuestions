package main.pathcount;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * There is an N by M matrix of zeroes.
 * <p>
 * Given N and M, write a function to count the number of
 * ways of starting at the top-left corner and getting to the bottom-right corner.
 * <p>
 * You can only move right or down.
 * <p>
 * For example, given a 2 by 2 matrix,
 * you should return 2,
 * since there are two ways to get to the bottom-right:
 * <p>
 * Right, then down
 * Down, then right
 * <p>
 * Given a 5 by 5 matrix,
 * there are 70 ways to get to the bottom-right.
 */
public class PathCount {

    public static int countPossiblePaths(int n, int m) {
        if (n == 0 || m == 0) return 0;

        int[][] matrix = new int[n][m];

        return breadthFirstReversePathCount(matrix);
    }

    private static int breadthFirstReversePathCount(int[][] matrix) {
        final Queue<Point> toExplore = new LinkedBlockingQueue<>();

        // initialise queue with bottom right corner point
        toExplore.add(new Point(matrix.length - 1, matrix[0].length - 1));

        while (!toExplore.isEmpty()) {
            Point current = toExplore.remove();
            int x = current.x;
            int y = current.y;

            // increment the number of times this point was visited in matrix
            matrix[x][y]++;

            if (x > 0) toExplore.add(new Point(x - 1, y));
            if (y > 0) toExplore.add(new Point(x, y - 1));
        }

        return matrix[0][0];
    }
}
