package interview.OneAway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OneAwayTest {

    private final String inputA;
    private final String inputB;
    private final boolean expected;

    public OneAwayTest(String inputA, String inputB, boolean expected) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {"pale", "ple", true},
                {"pales", "pale", true},
                {"pale", "bale", true},
                {"pale", "bake", false},
                {"pale", "aple", false},
                {"a", "", true},
                {"", "a", true},
                {"a", "b", true},
                {"aa", "b", false},
                {"aa", "ba", true},
                {"aba", "ba", true},
                {"aba", "baa", false},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(String.format("'%s' -> '%s'", inputA, inputB), expected, OneAway.isOneEditAway(inputA, inputB));
    }
}
