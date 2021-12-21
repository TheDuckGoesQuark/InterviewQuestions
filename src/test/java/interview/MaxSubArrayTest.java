package interview;

import interview.maxsubarray.MaxSubArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubArrayTest {

    @Test
    public void getMaxSubArraysEmptyInput() {
        int[] input = new int[0];
        int[] result = MaxSubArray.getMaxSubArrays(input, 1);
        int[] expected = new int[0];

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSingleValue() {
        int[] input = new int[]{1};
        int[] result = MaxSubArray.getMaxSubArrays(input, 1);
        int[] expected = new int[]{1};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSingleValueKBiggerThanArray() {
        int[] input = new int[]{1};
        int[] result = MaxSubArray.getMaxSubArrays(input, 2);
        int[] expected = new int[]{1};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSingleValueKMuchBiggerThanArray() {
        int[] input = new int[]{1};
        int[] result = MaxSubArray.getMaxSubArrays(input, 3);
        int[] expected = new int[]{1};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysTwoValues() {
        int[] input = new int[]{1, 2};
        int[] result = MaxSubArray.getMaxSubArrays(input, 1);
        int[] expected = new int[]{1, 2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysTwoValuesKTwo() {
        int[] input = new int[]{1, 2};
        int[] result = MaxSubArray.getMaxSubArrays(input, 2);
        int[] expected = new int[]{2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysTwoValuesKTwoMaxFirst() {
        int[] input = new int[]{2, 1};
        int[] result = MaxSubArray.getMaxSubArrays(input, 2);
        int[] expected = new int[]{2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysThreeValuesKTwo() {
        int[] input = new int[]{1, 3, 5};
        int[] result = MaxSubArray.getMaxSubArrays(input, 2);
        int[] expected = new int[]{3, 5};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysFiveValuesKTwo() {
        int[] input = new int[]{1, 3, 5, 3, 1};
        int[] result = MaxSubArray.getMaxSubArrays(input, 2);
        int[] expected = new int[]{3, 5, 5, 3};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysFiveValuesKThree() {
        int[] input = new int[]{1, 3, 5, 3, 1};
        int[] result = MaxSubArray.getMaxSubArrays(input, 3);
        int[] expected = new int[]{5, 5, 5};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSixValuesKTwo() {
        int[] input = new int[]{1, 3, 5, 3, 1, 9};
        int[] result = MaxSubArray.getMaxSubArrays(input, 2);
        int[] expected = new int[]{3, 5, 5, 3, 9};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSixValuesKFour() {
        int[] input = new int[]{1, 3, 5, 3, 1, 9};
        int[] result = MaxSubArray.getMaxSubArrays(input, 4);
        int[] expected = new int[]{5, 5, 9};

        assertArrayEquals(expected, result);
    }
}