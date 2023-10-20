package interview.BrickWall;

import java.util.*;

/**
 * A wall consists of several rows of bricks of various integer lengths and uniform height.
 * Your goal is to find a vertical line going from the top to the bottom of the wall that cuts through the fewest number of bricks.
 * If the line goes through the edge between two bricks, this does not count as a cut.
 * <p>
 * For example, suppose the input is as follows, where values in each row represent the lengths of bricks in that row:
 * <p>
 * [[3, 5, 1, 1],
 * [2, 3, 3, 2],
 * [5, 5],
 * [4, 4, 2],
 * [1, 3, 3, 3],
 * [1, 1, 6, 1, 1]]
 * The best we can we do here is to draw a line after the eighth brick,
 * which will only require cutting through the bricks in the third and fifth row.
 * <p>
 * Given an input consisting of brick lengths for each row such as the one above,
 * return the fewest number of bricks that must be cut to create a vertical line.
 */
public class BrickWall {
    public static int getMinCutPosition(int[][] wall) {
        if (wall.length == 0) return 0;

        // map each row to a set of indices where cuts already exist (i.e. between bricks)
        // O(n)
        var cutIndexCount = new HashMap<Integer, Integer>();

        for (int[] row : wall) {
            var index = 0;
            for (int i = 0; i < row.length - 1; i++) {
                int brickLength = row[i];
                index += brickLength;
                cutIndexCount.compute(index, (key, val) -> val == null ? 1 : val + 1);
            }
        }

        var minCutIndex = -1;
        var maxCount = Integer.MIN_VALUE;
        for (var entry : cutIndexCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                minCutIndex = entry.getKey();
            }
        }

        return minCutIndex;
    }
}
