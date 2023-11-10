package interview.ctci.treesandgraphs.RouteBetweenNodes;

import interview.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RouteBetweenNodesTest {

    private final int[][] input;
    private final int nodeA;
    private final int nodeB;
    private final boolean expectedOutput;

    public RouteBetweenNodesTest(int[][] input, int nodeA, int nodeB, boolean expectedOutput) {
        this.input = input;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        // Test Case 1: Graph with a direct route from node 0 to node 3
                        new int[][]{
                                {0, 1, 1, 0},
                                {0, 0, 0, 1},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0}
                        },
                        0, 3, true
                },
                {
                        // Test Case 2: Graph with no route between nodes 1 and 2
                        new int[][]{
                                {0, 1, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 1},
                                {0, 0, 0, 0}
                        },
                        1, 2, false
                },
                {
                        // Test Case 3: Graph with a loop (cycle), no direct route between nodes 0 and 2
                        new int[][]{
                                {0, 1, 1, 0},
                                {1, 0, 0, 0},
                                {0, 0, 0, 1},
                                {0, 0, 0, 0}
                        },
                        0, 2,true
                },
                {
                        // Test Case 3.1: Graph with a loop (cycle), no direct route between nodes 0 and 2
                        new int[][]{
                                {0, 1, 1, 0},
                                {1, 0, 0, 0},
                                {0, 0, 0, 1},
                                {0, 0, 0, 0}
                        },
                        2, 0,false
                },
                {
                        // Test Case 4: Graph with a direct route from node 1 to node 3
                        new int[][]{
                                {0, 1, 0, 0},
                                {0, 0, 0, 1},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0}
                        },
                        1, 3, true
                },
                {
                        // Test Case 5: Graph with a direct route from node 2 to itself
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 0}
                        },
                        2, 2, true
                }
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        var testName = String.format("%d -> %d \n", nodeA, nodeB) + Util.twoDimensionalArrayToString(input);
        assertEquals(testName, expectedOutput, RouteBetweenNodes.routeBetweenTwoNodes(input, nodeA, nodeB));
    }
}
