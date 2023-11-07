package interview.ctci.arraysandstrings.StringRotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringRotationTest {

    private final String input1;
    private final String input2;
    private final boolean expectedResult;

    public StringRotationTest(String input1, String input2, boolean expectedResult) {
        this.input1 = input1;
        this.input2 = input2;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {"", "", true},
                {"waterbottle", "erbottlewat", true},
                {"cat", "tca", true},
                {"cat", "cta", false},
                {"cat", "atc", true},
                {"cat", "cat", true},
                {"four", "four", true},
                {"four", "ourf", true},
                {"four", "urfo", true},
                {"four", "rfou", true},
                {"four", "ofor", false},
                {"four", "rofu", false},
                {"teen", "neet", false},
                {"teen", "tene", false},
                {"teen", "eent", true},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(String.format("isRotation('%s','%s')", input1, input2), expectedResult, StringRotation.isRotation(input1, input2));
    }
}
