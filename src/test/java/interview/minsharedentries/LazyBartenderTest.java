package interview.minsharedentries;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class LazyBartenderTest {

    private final int[][] inputPreferences;
    private final int expectedOutput;

    public LazyBartenderTest(int[][] inputPreferences, int expectedOutput) {
        this.inputPreferences = inputPreferences;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {new int[][]{
                }, 0},
                {new int[][]{
                        {0},
                }, 1},
                {new int[][]{
                        {0, 1},
                }, 1},
                {new int[][]{
                        {0, 1, 2},
                }, 1},
                {new int[][]{
                        {0, 1, 2},
                        {0},
                }, 1},
                {new int[][]{
                        {0, 1, 2},
                        {1},
                }, 1},
                {new int[][]{
                        {0, 1, 2},
                        {2},
                }, 1},
                {new int[][]{
                        {0, 1, 2},
                        {3},
                }, 2},
                {new int[][]{
                        {0, 1, 2},
                        {3},
                        {3},
                }, 2},
                {new int[][]{
                        {0, 1, 2},
                        {3},
                        {4},
                }, 3},
                {new int[][]{
                        {0, 1, 3, 6},
                        {1, 4, 7},
                        {2, 4, 7, 5},
                        {3, 2, 5},
                        {5, 8}
                }, 2},
                {new int[][]{
                        {0, 1},
                        {0, 1},
                        {0, 1},
                        {0, 1},
                        {0, 1},
                }, 1},
                {new int[][]{
                        {0, 1},
                        {0, 1},
                        {0, 1},
                        {2, 3},
                }, 2},
                {new int[][]{
                        {0, 2},
                        {0, 1, 2},
                        {0, 1},
                        {1, 4},
                        {2, 3, 5},
                }, 2},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void findMinRecipesNeeded() {
        Assert.assertEquals(Arrays.toString(inputPreferences), expectedOutput, LazyBartender.findMinRecipesNeeded(inputPreferences));
    }
}