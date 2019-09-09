package main.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits.
 * <p>
 * The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid)
 * must contain all of the digits from 1 to 9.
 * <p>
 * Implement an efficient sudoku solver.
 *
 * // TODO ...
 */
public class SudokuSolver {

    public static final int UNSET = 0;

    public static void solve(int[][] puzzle) {
        if (puzzle.length != 9 || puzzle[0].length != 9)
            throw new IllegalArgumentException("Sudoku grid must be 9 x 9");

        // to reduce checks create set for each column, row, and square
        // remove and add to column, row, square accordingly
        // use sets for O(1) lookup that value can be accepted
        final List<Set<Integer>> rows = new ArrayList<>(9);
        final List<Set<Integer>> cols = new ArrayList<>(9);
        final List<Set<Integer>> boxes = new ArrayList<>(9);

        initialiseKnownNumbers(rows, cols, boxes, puzzle);

        if (!recursivelySolve(puzzle, rows, cols, boxes, new SudokuIterator(puzzle)))
            throw new IllegalArgumentException("Unable to solve.");
    }

    /**
     * Initialise the sets with all numbers given in the puzzle
     *
     * @param rows   set of numbers found for each row
     * @param cols   set of numbers found for each col
     * @param boxes  set of numbers found for each box
     * @param puzzle puzzle containing initial values
     */
    private static void initialiseKnownNumbers(List<Set<Integer>> rows, List<Set<Integer>> cols, List<Set<Integer>> boxes, int[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        final SudokuIterator iter = new SudokuIterator(puzzle);

        iter.forEachRemaining(v -> {
            if (!addValueToSets(rows, cols, boxes, v, iter.getRowIndex(), iter.getColIndex(), iter.getBoxIndex()))
                throw new IllegalArgumentException("Initial puzzle is invalid.");
        });
    }

    /**
     * Adds the value to the corresponding sets for that index
     *
     * @param rows     set for each row
     * @param cols     set for each column
     * @param boxes    set for each box
     * @param value    value to add
     * @param rowIndex index of row in puzzle
     * @param colIndex index of column in puzzle
     * @param boxIndex index of box in puzzle
     * @return true if set added, false if value already existed in any of the three sets
     */
    private static boolean addValueToSets(List<Set<Integer>> rows, List<Set<Integer>> cols, List<Set<Integer>> boxes, int value, int rowIndex, int colIndex, int boxIndex) {
        if (value == UNSET) return true;

        final Set<Integer> rowSet = rows.get(rowIndex);
        final Set<Integer> colSet = cols.get(colIndex);
        final Set<Integer> boxSet = boxes.get(boxIndex);

        if (rowSet.contains(value) || colSet.contains(value) || boxSet.contains(value))
            return false;

        rowSet.add(value);
        colSet.add(value);
        boxSet.add(value);

        return true;
    }


    /**
     * Solves the puzzle using recursive backtracking, by iterating over each cell in the puzzle,
     * providing a possible value from 1-9 and continuing,
     * backtracking if a point is reached where no solution is possible.
     *
     * @param puzzle puzzle to solve
     * @param rows   memoized values for each row
     * @param cols   memoized values for each column
     * @param boxes  memoized values for each box
     * @param iter   puzzle iterator
     * @return true if solved, false otherwise
     */
    private static boolean recursivelySolve(int[][] puzzle, List<Set<Integer>> rows, List<Set<Integer>> cols, List<Set<Integer>> boxes, SudokuIterator iter) {
        // for each entry, try value, check constraints, explore further
        // backtrack on failure

        // skip set values
        while (iter.hasNext() && iter.next() != UNSET) ;

        // no more values, solved!
        if (!iter.hasNext())
            return true;

        // try each value, check it can be placed before setting the value and exploring
        Set<Integer> row = rows.get(iter.getRowIndex());
        Set<Integer> col = cols.get(iter.getColIndex());
        Set<Integer> box = boxes.get(iter.getBoxIndex());

        for (int i = 1; i < 9; i++) {
            if (canBeSet(i, row, col, box)) {
                iter.set(i);
                row.add(i);
                col.add(i);
                box.add(i);

                // check for success
                if (recursivelySolve(puzzle, rows, cols, boxes, iter))
                    return true;

                // undo assignment if fails
                iter.set(UNSET);
                row.remove(i);
                col.remove(i);
                box.remove(i);
            }
        }

        return false;
    }

    private static boolean canBeSet(int i, Set<Integer> row, Set<Integer> col, Set<Integer> box) {
        return !(row.contains(i) || col.contains(i) || box.contains(i));
    }
}
