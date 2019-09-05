package main.sudoku;

/**
 * Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid) must contain all of the digits from 1 to 9.
 * <p>
 * Implement an efficient sudoku solver.*
 */
public class SudokuSolver {

    public static void solve(int[][] puzzle) {
        if (puzzle.length != 9 || puzzle[0].length != 9)
            throw new IllegalArgumentException("Sudoku grid must be 9 x 9");

        // for each entry, try value, check constraints, explore further
        // backtrack on failure

        // to reduce checks create set for each column, row, and square
        // remove and add to column, row, square accordingly
        // use sets for O(1) lookup that value can be accepted
    }

}
