package interview.ctci.linkedlists.Intersection;

import interview.ctci.linkedlists.LinkedListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IntersectionTest {

    private final int[] initialA;
    private final int[] initialB;
    private final int[] intersectingRest;

    public IntersectionTest(int[] initialA, int[] initialB, int[] intersectingRest) {
        this.initialA = initialA;
        this.initialB = initialB;
        this.intersectingRest = intersectingRest;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                { // no intersection,
                        new int[]{0},
                        new int[]{1},
                        null,
                },
                { // no intersection
                        new int[]{0, 1},
                        new int[]{2, 3},
                        null,
                },
                { // no intersection
                        new int[]{0, 1, 2},
                        new int[]{3, 4, 5},
                        null,
                },
                { // no intersection
                        new int[]{0, 1, 2, 3},
                        new int[]{4, 5, 6, 7},
                        null,
                },

                { // no intersection
                        new int[]{0, 1},
                        new int[]{2},
                        null,
                },
                { // no intersection
                        new int[]{0, 1, 2},
                        new int[]{3, 4},
                        null,
                },
                { // no intersection
                        new int[]{0, 1, 2, 3},
                        new int[]{4, 5, 6},
                        null,
                },

                { // no intersection
                        new int[]{0, 1, 2},
                        new int[]{3},
                        null,
                },
                { // no intersection
                        new int[]{0, 1, 2, 3},
                        new int[]{4, 5},
                        null,
                },
                { // no intersection
                        new int[]{0, 1, 2, 3},
                        new int[]{4},
                        null,
                },

                { // intersecting on 1
                        new int[]{0},
                        new int[]{},
                        new int[]{1},
                },
                { // intersecting on 1
                        new int[]{0},
                        new int[]{},
                        new int[]{1, 2},
                },
                { // intersecting on 1
                        new int[]{0},
                        new int[]{},
                        new int[]{1, 2, 3},
                },

                { // intersection on 4
                        new int[]{0, 1},
                        new int[]{2, 3},
                        new int[]{4, 5},
                },
                { // intersection on 6
                        new int[]{0, 1, 2},
                        new int[]{3, 4, 5},
                        new int[]{6, 7, 8},
                },
                { // intersection on 8
                        new int[]{0, 1, 2, 3},
                        new int[]{4, 5, 6, 7},
                        new int[]{8, 9, 10}
                },
                { // shared first el
                        new int[]{},
                        new int[]{},
                        new int[]{0}
                },
                { // shared first el
                        new int[]{},
                        new int[]{},
                        new int[]{0, 1}
                },
                { // shared first el
                        new int[]{},
                        new int[]{},
                        new int[]{0, 1, 2}
                },
                { // shared first el
                        new int[]{},
                        new int[]{},
                        new int[]{0, 1, 2, 3}
                },
        };
        return Arrays.asList(inputs);
    }

    private LinkedListNode[] setupTest() {
        // tests with no intersection
        if (intersectingRest == null) {
            return new LinkedListNode[]{
                    LinkedListNode.fromArray(initialA),
                    LinkedListNode.fromArray(initialB),
                    null,
            };
        }
        // tests with intersection
        var intersectingNode = LinkedListNode.fromArray(intersectingRest);
        var aHead = initialA.length == 0 ? intersectingNode : LinkedListNode.fromArray(initialA);
        var bHead = initialB.length == 0 ? intersectingNode : LinkedListNode.fromArray(initialB);

        if (initialA.length != 0) {
            aHead.append(intersectingNode);
        }
        if (initialB.length != 0) {
            bHead.append(intersectingNode);
        }

        return new LinkedListNode[]{aHead, bHead, intersectingNode};
    }


    @Test
    public void test() {
        var lists = setupTest();
        var intersectingNode = lists[2];
        var testName = String.format("\n1: %s\n2: %s\ni: %s", lists[0], lists[1], intersectingNode);
        assertEquals(testName, intersectingNode, Intersection.getIntersectingNode(lists[0], lists[1]));
    }

}
