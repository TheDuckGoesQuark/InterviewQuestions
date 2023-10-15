package interview.runnerspath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class RoutePlannerTest {

    private final int[] elevations;
    private final int[][] paths;

    private final int expectedLength;

    public RoutePlannerTest(int[] elevations, int[][] paths, int expectedLength) {
        this.elevations = elevations;
        this.paths = paths;
        this.expectedLength = expectedLength;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[]{5, 25, 15, 20, 10},
                        new int[][]{
                                {0, 1, 10},
                                {0, 2, 8},
                                {0, 3, 15},
                                {1, 3, 12},
                                {2, 4, 10},
                                {3, 4, 5},
                                {3, 0, 17},
                                {4, 0, 10}
                        },
                        28
                },
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void findShortestPathLength() {
        assertEquals(expectedLength, RoutePlanner.findShortestPathLength(elevations, paths), Arrays.toString(paths));
    }
}