package interview.PalindromePermutation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PalindromePermutationTest {

    private final String input;
    private final boolean expectedOutput;

    public PalindromePermutationTest(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {"tact coa", true},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(input, expectedOutput, PalindromePermutation.isPermutationOfPalindrome(input));
    }
}
