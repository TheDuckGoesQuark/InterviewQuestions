import main.arrayinversions.ArrayInversions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

/**
 * For example, a sorted list has zero inversions.
 * The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3).
 * The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */

@RunWith(Parameterized.class)
public class ArrayInversionsTest {

    private final int[] input;
    private final int expected;

    public ArrayInversionsTest(int[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] inputs = new Object[][]{
                {new int[]{}, 0},
                {new int[]{2, 4, 1, 3, 5}, 3},
                {new int[]{5, 4, 3, 2, 1}, 10},
        };

        return Arrays.asList(inputs);
    }

    @Test
    public void countNumInversions() {
        assertEquals(expected, ArrayInversions.countNumInversions(input));
    }
}