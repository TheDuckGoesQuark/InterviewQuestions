package interview.StringCompression;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringCompressionTest {

    private final String input;
    private final String expectedOutput;

    public StringCompressionTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {"aabcccccaaa", "a2b1c5a3"},
                {"aaa", "a3"},
                {"a", "a"},
                {"ab", "ab"},
                {"abb", "abb"},
                {"abbb", "abbb"},
                {"abbbb", "a1b4"},
                {"abbbbbbbbbbbb", "a1b12"},
                {"abbbbbbbbbbbba", "a1b12a1"},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(input, expectedOutput, StringCompression.compress(input));
    }
}
