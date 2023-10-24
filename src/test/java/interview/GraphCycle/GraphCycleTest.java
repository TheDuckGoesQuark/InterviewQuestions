package interview.GraphCycle;

import interview.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GraphCycleTest {

    private final int[][] inputGraph;
    private final boolean expectedContainsCycle;

    public GraphCycleTest(int[][] inputGraph, boolean expectedContainsCycle) {
        this.inputGraph = inputGraph;
        this.expectedContainsCycle = expectedContainsCycle;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                // A simple undirected graph with a cycle of length 3
                {new int[][]{
                        {0, 1, 1},
                        {1, 0, 1},
                        {1, 1, 0}
                }, true},

                // An undirected graph without cycles
                {new int[][]{
                        {0, 1, 0, 0},
                        {1, 0, 0, 0},
                        {0, 0, 0, 1},
                        {0, 0, 1, 0}
                }, false},

                // An undirected graph with a single isolated vertex
                {new int[][]{
                        {0}
                }, false},

                // An undirected graph with multiple isolated vertices
                {new int[][]{
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                }, false},

                // An undirected graph with a simple cycle of length 4
                {new int[][]{
                        {0, 1, 0, 0, 1},
                        {1, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0},
                        {0, 0, 1, 0, 1},
                        {1, 0, 0, 1, 0}
                }, true},

                // An undirected graph with multiple cycles
                {new int[][]{
                        {0, 1, 0, 1, 0},
                        {1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 0, 1},
                        {0, 0, 1, 1, 0}
                }, true},

                // An undirected graph with a cycle
                {new int[][]{
                        {0, 1, 0, 0, 0},
                        {1, 0, 0, 1, 0},
                        {0, 0, 0, 1, 1},
                        {0, 1, 1, 0, 1},
                        {0, 0, 1, 1, 0}
                }, true},

                // A larger undirected complete graph
                {new int[][]{
                        {0, 1, 1, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 0}
                }, true},

                // A disconnected undirected graph with no cycles
                {new int[][]{
                        {0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0}
                }, false}
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals("\n" + Util.twoDimensionalArrayToString(inputGraph), expectedContainsCycle, GraphCycle.containsCycle(inputGraph));
    }
}
