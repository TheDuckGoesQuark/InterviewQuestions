package test;

import main.sumtok.SumToK;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


@RunWith(Parameterized.class)
public class SumToKTest {

    private final List<Integer> allowed;
    private final int target;
    private final List<Integer> expected;

    public SumToKTest(List<Integer> allowed, int target, List<Integer> expected) {
        this.allowed = allowed;
        this.target = target;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] parameters = new Object[][]{
                {new LinkedList<>(Arrays.asList(12, 1, 61, 5, 9, 2)), 24, Arrays.asList(12, 9, 2, 1)},
                {new LinkedList<>(Arrays.asList(3, 34, 4, 12, 5, 2)), 9, Arrays.asList(4, 5)},
                {new LinkedList<>(Arrays.asList(1)), 1, Arrays.asList(1)},
                {new LinkedList<>(Arrays.asList(1, 2)), 3, Arrays.asList(1, 2)},
                {new LinkedList<>(Arrays.asList(1, 2, 15)), 16, Arrays.asList(1, 15)},
        };

        return Arrays.asList(parameters);
    }

    @Test
    public void test() {
        final Optional<List<Integer>> result = SumToK.getSubsetThatAddsToK(allowed, target);
        assertTrue(result.isPresent());
        Collections.sort(expected);
        Collections.sort(result.get());
        assertEquals(expected, result.get());
    }
}