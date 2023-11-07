package interview.ctci.arraysandstrings.ZeroMatrix;

import interview.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ZeroMatrixTest {

    private final int[][] input;
    private final int[][] expectedOutput;

    public ZeroMatrixTest(int[][] input, int[][] expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[][]{},
                        new int[][]{},
                },
                {
                        new int[][]{{0}},
                        new int[][]{{0}},
                },
                {
                        new int[][]{{1}},
                        new int[][]{{1}},
                },
                {
                        new int[][]{{1, 1}},
                        new int[][]{{1, 1}},
                },
                {
                        new int[][]{{1, 0}},
                        new int[][]{{0, 0}},
                },
                {
                        new int[][]{{0, 1}},
                        new int[][]{{0, 0}},
                },
                {
                        new int[][]{{1, 1}, {1, 1}},
                        new int[][]{{1, 1}, {1, 1}},
                },
                {
                        new int[][]{{0, 1}, {1, 1}},
                        new int[][]{{0, 0}, {0, 1}},
                },
                {
                        new int[][]{{1, 0}, {1, 1}},
                        new int[][]{{0, 0}, {1, 0}},
                },
                {
                        new int[][]{{1, 1}, {0, 1}},
                        new int[][]{{0, 1}, {0, 0}},
                },
                {
                        new int[][]{{1, 1}, {1, 0}},
                        new int[][]{{1, 0}, {0, 0}},
                },
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertArrayEquals(Util.twoDimensionalArrayToString(input), expectedOutput, ZeroMatrix.zeroMatrix(input));
    }
}
