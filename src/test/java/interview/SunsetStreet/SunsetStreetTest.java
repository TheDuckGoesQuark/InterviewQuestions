package interview.SunsetStreet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SunsetStreetTest {

    private final int[] inputHeights;
    private final int expectedOutput;

    public SunsetStreetTest(int[] inputHeights, int expectedOutput) {
        this.inputHeights = inputHeights;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        // [east -> west] <- sunset
        final var inputs = new Object[][]{
                {
                        new int[]{1},
                        1
                },
                {
                        new int[]{2, 1},
                        2
                },
                {
                        new int[]{1, 1},
                        1
                },
                {
                        new int[]{1, 2},
                        1
                },
                {
                        new int[]{2, 3, 2},
                        2
                },
                {
                        new int[]{3, 7, 8, 3, 6, 1},
                        3
                }
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(Arrays.toString(inputHeights), expectedOutput, SunsetStreet.countBuildingsWithViewOfSunset(inputHeights));
    }
}
