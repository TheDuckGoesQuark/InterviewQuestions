package interview.ctci.linkedlists.SumLists;

import interview.ctci.linkedlists.LinkedListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SumListsTest {

    private final int[] inputA;
    private final int[] inputB;
    private final int[] expectedOutput;

    public SumListsTest(int[] inputA, int[] inputB, int[] expectedOutput) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[]{6, 1, 7},
                        new int[]{2, 9, 5},
                        new int[]{9, 1, 2}
                },
                {
                        new int[]{0},
                        new int[]{0},
                        new int[]{0}
                },
                {
                        new int[]{1},
                        new int[]{0},
                        new int[]{1}
                },
                {
                        new int[]{0},
                        new int[]{1},
                        new int[]{1}
                },
                {
                        new int[]{9},
                        new int[]{1},
                        new int[]{1, 0}
                },
                {
                        new int[]{0, 9},
                        new int[]{1, 2},
                        new int[]{2, 1}
                },
        };
        return Arrays.asList(inputs);
    }

    private static int[] reverseArray(int[] input) {
        var output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[output.length - 1 - i] = input[i];
        }
        return output;
    }

    @Test
    public void testReversed() {
        var testName = Arrays.toString(inputA) + " + " + Arrays.toString(inputB) + " = " + Arrays.toString(expectedOutput);
        var actualOutput = SumLists.sumListsReversed(
                LinkedListNode.fromArray(reverseArray(inputA)),
                LinkedListNode.fromArray(reverseArray(inputB))
        ).toArray();
        assertArrayEquals(
                testName,
                reverseArray(expectedOutput),
                actualOutput
        );
    }

    @Test
    public void testRegular() {
        var testName = Arrays.toString(inputA) + " + " + Arrays.toString(inputB) + " = " + Arrays.toString(expectedOutput);
        var actualOutput = SumLists.sumLists(
                LinkedListNode.fromArray(inputA),
                LinkedListNode.fromArray(inputB)
        ).toArray();
        assertArrayEquals(testName, expectedOutput, actualOutput);
    }
}
