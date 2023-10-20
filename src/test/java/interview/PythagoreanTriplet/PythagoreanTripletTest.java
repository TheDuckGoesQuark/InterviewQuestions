package interview.PythagoreanTriplet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PythagoreanTripletTest {

    private final int[] inputArr;
    private final boolean expectedContains;

    public PythagoreanTripletTest(int[] inputArr, boolean expectedContains) {
        this.inputArr = inputArr;
        this.expectedContains = expectedContains;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {new int[]{}, false},
                {new int[]{1}, false},
                {new int[]{1, 2}, false},
                {new int[]{1, 2, 3}, false},
                {new int[]{3, 4, 5}, true},
                {new int[]{5, 12, 13}, true},
                {new int[]{1, 9, 12, 4, 5, 12, 12, 51, 2, 5, 13}, true},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(Arrays.toString(inputArr) + ":" + expectedContains, expectedContains, PythagoreanTriplet.containsPythagoreanTriplet(inputArr));
    }
}
