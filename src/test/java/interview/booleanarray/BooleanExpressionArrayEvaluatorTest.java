package interview.booleanarray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class BooleanExpressionArrayEvaluatorTest {

    private final char[] booleanCharacters;
    private final int expectedOutput;

    public BooleanExpressionArrayEvaluatorTest(char[] booleanCharacters, int expectedOutput) {
        this.booleanCharacters = booleanCharacters;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {new char[]{'T', '&', 'T'}, 1},
                {new char[]{'T', '^', 'T'}, 0},
                {new char[]{'T', '|', 'T'}, 1},

                {new char[]{'F', '&', 'T'}, 0},
                {new char[]{'F', '^', 'T'}, 1},
                {new char[]{'F', '|', 'T'}, 1},

                {new char[]{'F', '&', 'F'}, 0},
                {new char[]{'F', '^', 'F'}, 0},
                {new char[]{'F', '|', 'F'}, 0},

                {new char[]{'F', '|', 'T', '&', 'T'}, 2},
                {new char[]{'F', '|', 'F', '&', 'T'}, 0},
                {new char[]{'T', '|', 'F', '&', 'T'}, 2},
                {new char[]{'T', '&', 'T', '&', 'T', '&', 'T'}, 5},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void countTrueParenthesisCombinations() {
        var count = BooleanExpressionArrayEvaluator.countParenthesesGroupingThatEvaluateToTrue(booleanCharacters);
        assertEquals(expectedOutput, count, Arrays.toString(booleanCharacters) + ": Count equals");
    }
}