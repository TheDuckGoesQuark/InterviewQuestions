package main.sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits.
 * <p>
 * The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid)
 * must contain all of the digits from 1 to 9.
 * <p>
 * Implement an efficient sudoku solver.
 */
public class SudokuSolver {

    public static void solve(int[][] puzzle) {
        if (puzzle.length != 9 || puzzle[0].length != 9)
            throw new IllegalArgumentException("Sudoku grid must be 9 x 9");

        // to reduce checks create set for each column, row, and square
        // remove and add to column, row, square accordingly
        // use sets for O(1) lookup that value can be accepted
        final Set[] rows = new Set[9];
        final Set[] cols = new Set[9];
        final Set[] boxes = new Set[9];

        initialiseKnownNumbers(rows, cols, boxes);
        recursivelySolve(puzzle, rows, cols, boxes);

        // for each entry, try value, check constraints, explore further
        // backtrack on failure

    }

    private static void initialiseKnownNumbers(Set[] rows, Set[] cols, Set[] boxes) {
        for (int i = 0; i < 6; i++) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }
    }

    private static void recursivelySolve(int[][] puzzle, Set[] rows, Set[] cols, Set[] boxes) {
    }

}
