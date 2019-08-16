package test;

import main.sumtok.SumToK;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

import static junit.framework.TestCase.assertEquals;


@RunWith(Parameterized.class)
public class SumToKTest {

    private final List<Integer> allowed;
    private final int target;
    private final Set<Integer> expected;

    public SumToKTest(List<Integer> allowed, int target, Set<Integer> expected) {
        this.allowed = allowed;
        this.target = target;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] parameters = new Object[][]{
                {Arrays.asList(12, 1, 61, 5, 9, 2), 24, new HashSet<>(Arrays.asList(12, 9, 2, 1))},
                {Arrays.asList(3, 34, 4, 12, 5, 2), 9, new HashSet<>(Arrays.asList(4, 5))},
                {Arrays.asList(1), 1, new HashSet<>(Arrays.asList(1))},
                {Arrays.asList(1, 2), 3, new HashSet<>(Arrays.asList(1, 2))},
                {Arrays.asList(1, 2, 15), 16, new HashSet<>(Arrays.asList(1, 15))},
        };

        return Arrays.asList(parameters);
    }

    @Test
    public void test() {
        assertEquals(expected, SumToK.getSubsettThatAddsToK(allowed, target));
    }
}