package interview.ThrowDice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ThrowDiceTest {

    private final int nDice;
    private final int nFaces;
    private final int total;

    private final int expectedCount;

    public ThrowDiceTest(int nDice, int nFaces, int total, int expectedCount) {
        this.nDice = nDice;
        this.nFaces = nFaces;
        this.total = total;
        this.expectedCount = expectedCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                // ndice, nfaces, total, expectedCount
                {1, 1, 2, 0},
                {1, 2, 2, 1},
                {2, 1, 2, 1},
                {2, 2, 2, 1},
                {3, 6, 7, 15},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(String.format("throw_dice(%d,%d,%d)=%s", nDice, nFaces, total, expectedCount), expectedCount, ThrowDice.numWaysToAchieveTotal(nDice, nFaces, total));
    }
}
