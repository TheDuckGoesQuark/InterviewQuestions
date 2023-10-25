package interview.TimeToReceiveMessage;

import interview.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TimeToReceiveMessageTest {

    private final int[][] edges;
    private final int expectedTime;

    public TimeToReceiveMessageTest(int[][] edges, int expectedTime) {
        this.edges = edges;
        this.expectedTime = expectedTime;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[][]{
                                {0, 1, 5},
                                {0, 2, 3},
                                {0, 5, 4},
                                {1, 3, 8},
                                {2, 3, 1},
                                {3, 5, 10},
                                {3, 4, 5}
                        },
                        9
                }
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(
                Util.twoDimensionalArrayToString(edges),
                expectedTime,
                TimeToReceiveMessage.findTimeForAllNodesToReceiveMessage(edges)
        );
    }
}
