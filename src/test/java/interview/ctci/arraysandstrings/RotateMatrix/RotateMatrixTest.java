package interview.ctci.arraysandstrings.RotateMatrix;

import interview.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RotateMatrixTest {

    private final int[][] input;
    private final int[][] expectedOutput;

    public RotateMatrixTest(int[][] input, int[][] expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[][]{{0}},
                        new int[][]{{0}}
                },
                {
                        new int[][]{{0, 1}, {2, 3}},
                        new int[][]{{2, 0}, {3, 1}}
                },
                {
                        new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}},
                        new int[][]{{6, 3, 0}, {7, 4, 1}, {8, 5, 2}},
                },
                {
                        new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}},
                        new int[][]{{12, 8, 4, 0}, {13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}}
                },
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        var output = RotateMatrix.rotateImage(input);
        assertArrayEquals(Util.twoDimensionalArrayToString(input), expectedOutput, output);
    }
}
