package interview.CheckPermutation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckPermutationTest {

    private final String inputA;
    private final String inputB;
    private final boolean expectedOutput;

    public CheckPermutationTest(String inputA, String inputB, boolean expectedOutput) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {"a", "a", true},
                {"ab", "ba", true},
                {"aa", "ba", false},
                {"caba", "acab", true},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(String.format("'%s' == '%s'", inputA, inputB), expectedOutput, CheckPermutation.isPermutation(inputA, inputB));
    }
}
