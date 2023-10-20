package interview.BrickWall;

import interview.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BrickWallTest {

    private final int[][] inputWall;
    private final int expectedCutPosition;

    public BrickWallTest(int[][] inputWall, int expectedCutPosition) {
        this.inputWall = inputWall;
        this.expectedCutPosition = expectedCutPosition;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[][]{
                                {3, 5, 1, 1},
                                {2, 3, 3, 2},
                                {5, 5},
                                {4, 4, 2},
                                {1, 3, 3, 3},
                                {1, 1, 6, 1, 1}
                        },
                        8 // after the eighth brick, which will only require cutting through the bricks in the third and fifth row.
                }
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(Util.twoDimensionalArrayToString(inputWall), expectedCutPosition, BrickWall.getMinCutPosition(inputWall));
    }
}
