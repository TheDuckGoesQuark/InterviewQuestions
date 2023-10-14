package interview.longestslidingwindow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class LongestSlidingWindowFinderTest {

    private final int[] input;
    private final int expectedOutput;

    public LongestSlidingWindowFinderTest(int[] input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {new int[]{}, 0},
                {new int[]{0}, 1},
                {new int[]{0, 0}, 2},
                {new int[]{0, 0, 0}, 3},
                {new int[]{0, 0, 0, 0}, 4},
                {new int[]{0}, 1},
                {new int[]{0, 1}, 2},
                {new int[]{0, 1, 1}, 3},
                {new int[]{0, 1, 1, 1}, 4},
                {new int[]{0, 1}, 2},
                {new int[]{1, 0, 1}, 3},
                {new int[]{0, 1, 0, 1}, 4},
                {new int[]{0, 1, 2, 3}, 2},
                {new int[]{0, 1, 2, 1}, 3},
                {new int[]{0, 1, 0, 2}, 3},
                {new int[]{1, 1, 2, 2}, 4},
                {new int[]{1, 1, 2, 2, 3, 3, 1, 1}, 4},
                {new int[]{1, 1, 2, 2, 1, 3, 1, 1}, 5},
                {new int[]{2, 1, 2, 3, 3, 1, 3, 5}, 4}
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void findLongestWindowOfTwoNumbers() {
        assertEquals(expectedOutput, LongestSlidingWindowFinder.findLongestWindowOfTwoNumbers(input), Arrays.toString(input));
    }
}