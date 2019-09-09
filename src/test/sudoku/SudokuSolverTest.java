package test.sudoku;

import main.sudoku.SudokuIterator;
import main.sudoku.SudokuSolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class SudokuSolverTest {

    private int[][] input;
    private int[][] expected;

    public SudokuSolverTest(int[][] input, int[][] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final int[][] solved = new int[][]{
                {8, 5, 9, 3, 4, 6, 2, 7, 1},
                {6, 3, 1, 2, 9, 7, 8, 5, 4},
                {4, 7, 2, 8, 1, 5, 6, 3, 9},
                {7, 9, 8, 4, 6, 2, 3, 1, 5},
                {5, 1, 6, 7, 8, 3, 9, 4, 2},
                {3, 2, 4, 1, 5, 9, 7, 8, 6},
                {2, 8, 5, 9, 3, 4, 1, 6, 7},
                {1, 6, 7, 5, 2, 8, 4, 9, 3},
                {9, 4, 3, 6, 7, 1, 5, 2, 8},
        };

        final Object[][] data = new Object[][]{
                {
                        new int[][]{
                                {0, 5, 9, 3, 4, 6, 2, 7, 1},
                                {6, 3, 1, 2, 9, 7, 8, 5, 4},
                                {4, 7, 2, 8, 1, 5, 6, 3, 9},
                                {7, 9, 8, 4, 6, 2, 3, 1, 5},
                                {5, 1, 6, 7, 8, 3, 9, 4, 2},
                                {3, 2, 4, 1, 5, 9, 7, 8, 6},
                                {2, 8, 5, 9, 3, 4, 1, 6, 7},
                                {1, 6, 7, 5, 2, 8, 4, 9, 3},
                                {9, 4, 3, 6, 7, 1, 5, 2, 8},
                        },
                        solved
                },
                {
                        new int[][]{
                                {0, 5, 9, 3, 4, 6, 2, 7, 1},
                                {6, 3, 1, 2, 9, 7, 0, 5, 4},
                                {4, 7, 2, 8, 1, 5, 6, 3, 9},
                                {7, 9, 8, 0, 6, 2, 3, 1, 5},
                                {5, 1, 6, 7, 8, 3, 9, 4, 2},
                                {3, 2, 4, 1, 5, 0, 7, 8, 6},
                                {2, 8, 5, 9, 3, 4, 1, 6, 7},
                                {1, 6, 7, 5, 2, 8, 4, 9, 3},
                                {9, 4, 3, 6, 7, 1, 0, 2, 8},
                        },
                        solved
                },
                {
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 9, 0, 8, 5, 0},
                                {4, 7, 0, 0, 1, 0, 0, 0, 0},
                                {0, 0, 0, 4, 6, 0, 0, 1, 0},
                                {0, 0, 0, 0, 0, 0, 9, 0, 2},
                                {0, 2, 4, 1, 0, 0, 7, 0, 0},
                                {0, 8, 5, 0, 0, 0, 0, 0, 0},
                                {1, 0, 7, 5, 0, 8, 0, 9, 0},
                                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                        },
                        solved
                }
        };

        return Arrays.asList(data);
    }

    private void print() {
        for (int i = 0; i < input.length; i++) {
            if (i % 3 == 0) {
                System.out.print("-".repeat(29));
                System.out.println();
            }

            for (int j = 0; j < input.length; j++) {
                if (j % 3 == 0) System.out.print("|");
                System.out.print(input[i][j] + ", ");
            }

            System.out.println();
        }
    }

    @Test
    public void name() {
        SudokuSolver.solve(input);
        print();
        assertArrayEquals(expected, input);
    }
}