package interview.ctci.linkedlists.RemoveDupes;

import interview.ctci.linkedlists.LinkedListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RemoveDupesTest {

    private final int[] input;
    private final int[] expectedOutput;

    public RemoveDupesTest(int[] input, int[] expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[]{0},
                        new int[]{0}
                },
                {
                        new int[]{0, 1},
                        new int[]{0, 1}
                },
                {
                        new int[]{0, 1, 0},
                        new int[]{0, 1}
                },
                {
                        new int[]{0, 1, 2, 0},
                        new int[]{0, 1, 2}
                },
                {
                        new int[]{1, 1, 1, 1},
                        new int[]{1}
                },
                {
                        new int[]{1, 2, 3, 4, 1, 2, 3, 4},
                        new int[]{1, 2, 3, 4}
                },
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void testWithBuffer() {
        var inputList = LinkedListNode.fromArray(input);
        var output = RemoveDupes.removeDupes(inputList);
        assertNotNull(output);
        assertArrayEquals(Arrays.toString(input), expectedOutput, output.toArray());
    }

    @Test
    public void testWithoutBuffer() {
        var inputList = LinkedListNode.fromArray(input);
        var output = RemoveDupes.removeDupesWithoutBuffer(inputList);
        assertNotNull(output);
        assertArrayEquals(Arrays.toString(input), expectedOutput, output.toArray());
    }
}
