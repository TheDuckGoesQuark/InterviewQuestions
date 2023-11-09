package interview.ctci.linkedlists.Palindrome;

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
public class PalindromeTest {

    private final int[] input;
    private final boolean expectedOutput;

    public PalindromeTest(int[] input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[]{1},
                        true,
                },
                {
                        new int[]{1, 2},
                        false,
                },
                {
                        new int[]{1, 2, 1},
                        true,
                },
                {
                        new int[]{1, 1},
                        true,
                },
                {
                        new int[]{1, 1, 1},
                        true,
                },
                {
                        new int[]{1, 2, 1, 1},
                        false,
                },
                {
                        new int[]{1, 2, 3, 2, 1},
                        true,
                },
                {
                        new int[]{1, 2, 2, 1},
                        true,
                },
                {
                        new int[]{1, 2, 3, 4, 2, 1},
                        false,
                },
                {
                        new int[]{1, 2, 3, 4, 3, 2, 1},
                        true,
                },
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        var list = LinkedListNode.fromArray(input);
        assertEquals(Arrays.toString(input), expectedOutput, Palindrome.isPalindrome(list));
    }
}
