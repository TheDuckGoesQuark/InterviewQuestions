package interview.dividedregions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class DividedRegionsCounterTest {

    private final char[][] input;

    private final int expectedOutput;

    public DividedRegionsCounterTest(char[][] input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                // 1D
                {new char[][]{{' '}}, 1},
                {new char[][]{{' ', '/', ' '}}, 2},
                {new char[][]{{' ', '\\', ' '}}, 2},
                {new char[][]{{' ', '/', ' ', '\\', ' '}}, 3},
                {new char[][]{{' ', '\\', ' ', '/', ' '}}, 3},
                {new char[][]{{' ', ' '}}, 1},
                {new char[][]{{' ', ' ', ' '}}, 1},
                {new char[][]{{' ', '/', ' ', '/', ' ', '/', ' '}}, 4},
                {new char[][]{{' ', '/', ' ', '\\', ' ', '/', ' '}}, 4},
                {new char[][]{{'/', ' ', '/'}}, 1},
                {new char[][]{{'\\', ' ', '/'}}, 1},
                {new char[][]{{'/', ' ', '/', ' '}}, 2},
                {new char[][]{{'\\', ' ', '/', ' '}}, 2},

                // 2D
                {new char[][]{
                        {'\\', ' ', ' ', ' ', ' ', '/'},
                        {' ', '\\', ' ', ' ', '/', ' '},
                        {' ', ' ', '\\', '/', ' ', ' '}
                }, 3},

                {new char[][]{
                        {'\\', '\\'},
                        {'/', '/'},
                        {'\\', '\\'}
                }, 0},
                {new char[][]{
                        {'/', '\\'},
                        {'\\', '/'},
                }, 0},
                {new char[][]{
                        {' ', ' '},
                        {' ', ' '},
                        {' ', ' '}
                }, 1},
                {new char[][]{
                        {' ', ' '},
                        {' ', '/',},
                        {' ', ' '}
                }, 1},
                {new char[][]{
                        {' ', ' ', ' '},
                        {' ', '/', ' '},
                        {' ', ' ', ' '}
                }, 1},
                {new char[][]{
                        {' ', ' '},
                        {' ', '\\',},
                        {' ', ' '}
                }, 1},
                {new char[][]{
                        {'\\', ' '},
                        {' ', ' ',},
                        {' ', ' '}
                }, 1},
                {new char[][]{
                        {'\\', ' '},
                        {' ', '\\',},
                        {' ', ' '}
                }, 2},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void countDividedRegions() {
        assertEquals(expectedOutput, DividedRegionsCounter.countDividedRegions(input), "\n" + Arrays.toString(Arrays.stream(input).map(row -> Arrays.toString(row) + "\n").toArray()));
    }

}