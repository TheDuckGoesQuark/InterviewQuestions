package interview.stonepyramid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class StonePyramidBuilderTest {

    private final int[] inputStones;
    private final int expectedCost;

    public StonePyramidBuilderTest(int[] inputStones, int expectedCost) {
        this.inputStones = inputStones;
        this.expectedCost = expectedCost;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {new int[]{1}, 0}, // 1
                {new int[]{1, 1, 1}, 2}, // 0,1,0
                {new int[]{1, 1, 1, 1}, 3}, // 0,0,1,0
                {new int[]{1, 1, 1, 1, 1}, 4}, // 0, 0, 1, 0, 0
                {new int[]{1, 1, 2, 1, 1}, 2}, // 0, 1, 2, 1, 0
                {new int[]{1, 1, 3, 1, 1}, 3}, // 0, 1, 2, 1, 0
                {new int[]{0, 1, 3, 2, 1}, 3}, // 0, 0, 1, 2, 1
                {new int[]{1, 1, 3, 3, 2, 1}, 2}, // 0, 1, 2, 3, 2, 1
                {new int[]{4, 3, 2, 1}, 6}, // 1, 2, 1, 0
                {new int[]{1, 2, 3, 4}, 6}, // 0, 1, 2, 1
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void testStonePyramidBuilder() {
        assertEquals(Arrays.toString(inputStones), expectedCost, StonePyramidBuilder.lowestCostToBuildPyramidFromStones(inputStones));
    }
}