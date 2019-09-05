package test.sudoku;

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
        Object[][] data = new Object[][]{
                {
                        new int[][]{
                                {0, 0, 0, 0, 0, 4, 0, 9, 0},
                                {8, 0, 2, 9, 7, 0, 0, 0, 0},
                                {9, 0, 1, 2, 0, 0, 3, 0, 0},
                                {0, 0, 0, 0, 4, 9, 1, 5, 7},
                                {0, 1, 3, 0, 5, 0, 9, 2, 0},
                                {5, 7, 9, 1, 2, 0, 0, 0, 0},
                                {0, 0, 7, 0, 0, 2, 6, 0, 3},
                                {0, 0, 0, 0, 3, 8, 2, 0, 5},
                                {0, 2, 0, 5, 0, 0, 0, 0, 0}
                        },
                        new int[][]{
                                {7, 3, 5, 6, 1, 4, 8, 9, 2},
                                {8, 4, 2, 9, 7, 5, 5, 6, 1},
                                {9, 6, 1, 2, 8, 3, 3, 7, 4},
                                {2, 8, 6, 3, 4, 9, 1, 5, 7},
                                {4, 1, 3, 8, 5, 7, 9, 2, 6},
                                {5, 7, 9, 1, 2, 6, 4, 3, 8},
                                {1, 5, 7, 4, 9, 2, 6, 8, 3},
                                {6, 9, 4, 7, 3, 8, 2, 1, 5},
                                {3, 2, 8, 5, 6, 1, 7, 4, 9}
                        },
                }
        };

        return Arrays.asList(data);
    }

    @Test
    public void name() {
        SudokuSolver.solve(input);

        for (int i = 0; i < input.length; i++) {
            assertArrayEquals(expected[i], input[i]);
        }
    }
}