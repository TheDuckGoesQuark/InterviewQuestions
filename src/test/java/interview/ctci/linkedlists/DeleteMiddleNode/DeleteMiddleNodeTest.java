package interview.ctci.linkedlists.DeleteMiddleNode;

import interview.ctci.linkedlists.LinkedListNode;
import interview.ctci.linkedlists.RemoveDupes.RemoveDupes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class DeleteMiddleNodeTest {

    private final int[] input;
    private final int indexToRemove;
    private final int[] expectedOutput;

    public DeleteMiddleNodeTest(int[] input, int indexToRemove, int[] expectedOutput) {
        this.input = input;
        this.indexToRemove = indexToRemove;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[]{0, 1, 2},
                        1,
                        new int[]{0, 2},
                },
                {
                        new int[]{0, 1, 2, 3},
                        1,
                        new int[]{0, 2, 3},
                },
                {
                        new int[]{0, 1, 2, 3},
                        2,
                        new int[]{0, 1, 3},
                },
                {
                        new int[]{0, 1, 2, 3, 4},
                        1,
                        new int[]{0, 2, 3, 4},
                },
                {
                        new int[]{0, 1, 2, 3, 4},
                        2,
                        new int[]{0, 1, 3, 4},
                },
                {
                        new int[]{0, 1, 2, 3, 4},
                        3,
                        new int[]{0, 1, 2, 4},
                },
        };
        return Arrays.asList(inputs);
    }

    private static LinkedListNode getNodeAtIndex(LinkedListNode head, int index) {
        if (index == 0) {
            return head;
        } else return getNodeAtIndex(head.next, index - 1);
    }

    @Test
    public void test() {
        var inputList = LinkedListNode.fromArray(input);
        var nodeToDelete = getNodeAtIndex(inputList, indexToRemove);
        DeleteMiddleNode.deleteNode(nodeToDelete);
        assertNotNull(inputList);
        assertArrayEquals(Arrays.toString(input), expectedOutput, inputList.toArray());
    }
}
