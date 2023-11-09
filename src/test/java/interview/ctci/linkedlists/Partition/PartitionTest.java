package interview.ctci.linkedlists.Partition;

import interview.ctci.linkedlists.LinkedListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PartitionTest {

    private final int[] input;
    private final int partitionValue;

    public PartitionTest(int[] input, int partitionValue) {
        this.input = input;
        this.partitionValue = partitionValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[]{3, 5, 8, 5, 10, 2, 1},
                        5,
                },
                {
                        new int[]{0, 1, 2, 3, 4, 5},
                        5,
                },
                {
                        new int[]{0},
                        0,
                },
                {
                        new int[]{5, 1, 2, 4, 9},
                        5,
                },
                {
                        new int[]{9, 5, 1, 2, 4, 9},
                        5,
                },
                {
                        new int[]{9, 5, 1, 2, 4, 9, 5},
                        5,
                },
        };
        return Arrays.asList(inputs);
    }

    private static boolean correctlyPartitioned(int[] originalArr, int[] partitionedArr, int x) {
        // all nodes less than x, come before all nodes greater than or equal to x
        var lessThanXCount = 0;
        var originalLessThanX = new HashMap<Integer, Integer>();
        var moreThanOrEqualToXCount = 0;
        var originalMoreThanOrEqualToX = new HashMap<Integer, Integer>();

        for (int val : originalArr) {
            if (val < x) {
                originalLessThanX.compute(val, (k, v) -> v == null ? 1 : v + 1);
                lessThanXCount++;
            } else {
                originalMoreThanOrEqualToX.compute(val, (k, v) -> v == null ? 1 : v + 1);
                moreThanOrEqualToXCount++;
            }
        }

        if (partitionedArr.length != (lessThanXCount + moreThanOrEqualToXCount)) return false;

        for (int i = 0; i < lessThanXCount; i++) {
            var count = originalLessThanX.get(partitionedArr[i]);
            if (count == null || count == 0) return false;
            originalLessThanX.put(partitionedArr[i], count - 1);
        }

        for (int i = 0; i < moreThanOrEqualToXCount; i++) {
            var index = i + lessThanXCount;
            var count = originalMoreThanOrEqualToX.get(partitionedArr[index]);
            if (count == null || count == 0) return false;
            originalMoreThanOrEqualToX.put(partitionedArr[index], count - 1);
        }

        // ensure all elements have been accounted for
        for (Integer remainingCount : originalLessThanX.values()) {
            if (remainingCount != 0) return false;
        }
        for (Integer remainingCount : originalMoreThanOrEqualToX.values()) {
            if (remainingCount != 0) return false;
        }

        return true;
    }

    @Test
    public void test() {
        var inputList = LinkedListNode.fromArray(input);
        var output = Partition.partition(inputList, partitionValue).toArray();
        var isPartitionedCorrectly = correctlyPartitioned(input, output, partitionValue);
        assertTrue(Arrays.toString(input) + "->" + Arrays.toString(output), isPartitionedCorrectly);
    }
}
