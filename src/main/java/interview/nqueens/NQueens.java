package interview.nqueens;

/**
 * You have an N by N board.
 * <p>
 * Write a function that returns the number of possible arrangements of the board
 * where N queens can be placed on the board without threatening each other,
 * i.e. no two queens share the same row, column, or diagonal.
 */
public class NQueens {

    public static int getNumberOfPossibleArrangements(int boardSize) {
        return recursivelyGetNumberOfPossibleArrangements(new int[boardSize], 0);
    }

    private static int recursivelyGetNumberOfPossibleArrangements(int[] currentQueens, int currentRow) {
        if (currentRow == currentQueens.length) return 1; // all queens placed, return possible solution

        int numberOfArrangements = 0;
        // For each column, place the queen and find all possible arrangements for queens on lower rows
        for (int currentColumn = 0; currentColumn < currentQueens.length; currentColumn++) {
            if (canPlaceQueen(currentQueens, currentRow, currentRow, currentColumn)) {

                currentQueens[currentRow] = currentColumn;

                numberOfArrangements += recursivelyGetNumberOfPossibleArrangements(currentQueens, currentRow + 1);
            }
        }

        return numberOfArrangements;
    }

    /**
     * Returns true if the coordinates of the new queen do not result in a threat to
     * an existing queen
     *
     * @param currentQueens x,y coordinates of each queen currently placed
     * @param nQueens       number of queens currently placed
     * @param newQueenX     x coordinate of new queen
     * @param newQueenY     y coordinate of new queen
     * @return true if the queen can be placed without threatening another queen
     */
    private static boolean canPlaceQueen(int[] currentQueens, int nQueens, int newQueenX, int newQueenY) {
        for (int currentQueenX = 0; currentQueenX < nQueens; currentQueenX++) {
            int currentQueenY = currentQueens[currentQueenX];

            // Check horizontals
            if (newQueenX == currentQueenX || newQueenY == currentQueenY)
                return false;

            // Check diagonals (y = mx + c, m = 1, on same diagonal if y1 (+/-) x1 == y2 (+/-) x2
            if (newQueenY - newQueenX == currentQueenY - currentQueenX
                    || newQueenY + newQueenX == currentQueenY + currentQueenX)
                return false;
        }

        return true;
    }
}
