package test.sudoku;

import main.sudoku.SudokuSolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SudokuSolverTest {

    private int[][] input;
    private int[][] expected;

    public SudokuSolverTest(int[][] input, int[][] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {
                        new int[][]{{8, 6, 0, 0, 2, 0, 0, 0, 0},
                                {0, 0, 0, 7, 0, 0, 0, 5, 9},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 6, 0, 8, 0, 0},
                                {0, 4, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 5, 3, 0, 0, 0, 0, 7},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 6, 0, 0},
                                {0, 0, 7, 5, 0, 9, 0, 0, 0}
                        },
                        // get answer
                        new int[][]{{8, 6, 0, 0, 2, 0, 0, 0, 0},
                                {0, 0, 0, 7, 0, 0, 0, 5, 9},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 6, 0, 8, 0, 0},
                                {0, 4, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 5, 3, 0, 0, 0, 0, 7},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 2, 0, 0, 0, 0, 6, 0, 0},
                                {0, 0, 7, 5, 0, 9, 0, 0, 0}
                        },
                }
        };

        return Arrays.asList(data);
    }

    @Test
    public void name() {
        SudokuSolver.solve(input);
        assertArrayEquals(expected, input);
    }
}