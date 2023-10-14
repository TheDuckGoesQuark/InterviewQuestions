package interview.dividedregions;

/**
 * You are given a 2-d matrix where each cell consists of either /, \, or an empty space. Write an algorithm that determines into how many regions the slashes divide the space.
 * <p>
 * For example, suppose the input for a three-by-six grid is the following:
 * <p>
 * \    /
 * \  /
 * \/
 * Considering the edges of the matrix as boundaries, this divides the grid into three triangles, so you should return 3.
 */
public class DividedRegionsCounter {


    private static final char BACKWARD_SLASH = '\\';
    private static final char FORWARD_SLASH = '/';
    private static final char EMPTY_SPACE = ' ';

    public static int countDividedRegions(char[][] arr) {
        var dividedRegionCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == EMPTY_SPACE) {
                    fillSpaceDepthFirst(arr, i, j);
                    dividedRegionCount++;
                }
            }
        }

        return dividedRegionCount;
    }

    private static void fillSpaceDepthFirst(char[][] arr, int row, int col) {
        if (isNotInBounds(arr, row, col) || getCharAtCoord(arr, row, col) != EMPTY_SPACE) {
            return;
        }

        arr[row][col] = FORWARD_SLASH;
        fillSpaceDepthFirst(arr, row + 1, col);
        fillSpaceDepthFirst(arr, row - 1, col);
        fillSpaceDepthFirst(arr, row, col + 1);
        fillSpaceDepthFirst(arr, row, col - 1);
    }

    private static boolean isNotInBounds(char[][] arr, int row, int col) {
        return (0 > row || row >= arr.length) || (0 > col || col >= arr[0].length);
    }

    private static char getCharAtCoord(char[][] arr, int row, int col) {
        return arr[row][col];
    }
}
