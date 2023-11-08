package interview.ctci.linkedlists.ReturnKthToLast;

import interview.ctci.linkedlists.LinkedListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReturnKthToLastTest {

    private final int[] input;
    private final int k;
    private final int expectedResult;

    public ReturnKthToLastTest(int[] input, int k, int expectedResult) {
        this.input = input;
        this.k = k;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[]{0},
                        0,
                        0
                },
                {
                        new int[]{0, 1},
                        0,
                        1
                },
                {
                        new int[]{0, 1},
                        1,
                        0
                },
                {
                        new int[]{0, 1, 2},
                        0,
                        2
                },
                {
                        new int[]{0, 1, 2},
                        1,
                        1
                },
                {
                        new int[]{0, 1, 2},
                        2,
                        0
                },
                {
                        new int[]{0, 1, 2, 3},
                        0,
                        3
                },
                {
                        new int[]{0, 1, 2, 3},
                        1,
                        2
                },
                {
                        new int[]{0, 1, 2, 3},
                        2,
                        1
                },
                {
                        new int[]{0, 1, 2, 3},
                        3,
                        0
                },
                {
                        new int[]{0, 1, 2, 3},
                        4,
                        -1
                },
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        var linkedList = LinkedListNode.fromArray(input);
        assertEquals(String.format("K:%d %s", k, Arrays.toString(input)), expectedResult, ReturnKthToLast.returnKthToLast(linkedList, k));
    }

    @Test
    public void testRecursive() {
        var linkedList = LinkedListNode.fromArray(input);
        assertEquals(String.format("K:%d %s", k, Arrays.toString(input)), expectedResult, ReturnKthToLast.returnKthToLastRecursively(linkedList, k));
    }
}
