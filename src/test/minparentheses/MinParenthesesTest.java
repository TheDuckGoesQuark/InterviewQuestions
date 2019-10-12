package test.minparentheses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
class MinParenthesesTest {

    private String input;
    private int expected;

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = {
                {"()())()", 1},
                {")(", 2},
        };
        return Arrays.asList(data);
    }

    public MinParenthesesTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void getMinNeedingRemoved() {

    }
}