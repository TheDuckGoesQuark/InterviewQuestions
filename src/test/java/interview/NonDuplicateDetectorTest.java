package interview;

import interview.findnonduplicatedinteger.NonDuplicateDetector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NonDuplicateDetectorTest {

    private int[] input;
    private int expected;

    public NonDuplicateDetectorTest(int[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][]{
                {new int[]{13, 19, 13, 13}, 19},
                {new int[]{2, 3, 3, 3}, 2},
                {new int[]{3, 2, 3, 3}, 2},
                {new int[]{3, 3, 2, 3}, 2},
                {new int[]{3, 3, 3, 2}, 2},
                {new int[]{1, 2, 3, 1, 2, 1, 2}, 3},
                {new int[]{1, 2, 2, 2, 3, 3, 3}, 1},
                {new int[]{6, 1, 3, 3, 3, 6, 6}, 1}
        };

        return Arrays.asList(data);
    }

    @Test
    public void test() {
        assertEquals(expected, NonDuplicateDetector.findNonDuplicate(input));
    }
}