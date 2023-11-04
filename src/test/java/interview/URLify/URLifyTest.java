package interview.URLify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class URLifyTest {

    private final char[] inputCharArray;
    private final int inputTrueStringSize;
    private final String expectedOutput;

    public URLifyTest(char[] input, int inputTrueStringSize, String expectedOutput) {
        this.inputCharArray = input;
        this.inputTrueStringSize = inputTrueStringSize;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {"Mr John Smith    ".toCharArray(), 13, "Mr%20John%20Smith"},
                {"      Mr John Smith                ".toCharArray(), 19, "%20%20%20%20%20%20Mr%20John%20Smith"}
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(Arrays.toString(inputCharArray), expectedOutput, URLify.urlify(inputCharArray, inputTrueStringSize));
    }
}
