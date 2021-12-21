package test.minparentheses;

import interview.minparentheses.MinParentheses;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MinParenthesesTest {

    private String input;
    private int expected;

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = {
                {"()())()", 1},
                {")(", 2},
                {"()(", 1},
                {"())", 1},
                {"(())", 0},
                {"(())(())", 0},
                {")()(()()(", 3},
        };
        return Arrays.asList(data);
    }

    public MinParenthesesTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void getMinNeedingRemoved() {
        assertEquals(expected, MinParentheses.getMinNeedingRemoved(input));
    }
}