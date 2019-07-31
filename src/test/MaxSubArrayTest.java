package test;

import main.maxsubarray.MaxSubArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubArrayTest {

    @Test
    public void getMaxSubArraysSingleValue() {
        int[] singleVal = new int[]{1};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 1);
        int[] expected = new int[]{1};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSingleValueKBiggerThanArray() {
        int[] singleVal = new int[]{1};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 2);
        int[] expected = new int[]{1};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSingleValueKMuchBiggerThanArray() {
        int[] singleVal = new int[]{1};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 3);
        int[] expected = new int[]{1};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysTwoValues() {
        int[] singleVal = new int[]{1, 2};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 1);
        int[] expected = new int[]{1, 2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysTwoValuesKTwo() {
        int[] singleVal = new int[]{1, 2};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 2);
        int[] expected = new int[]{2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysTwoValuesKTwoMaxFirst() {
        int[] singleVal = new int[]{2, 1};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 2);
        int[] expected = new int[]{2};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysThreeValuesKTwo() {
        int[] singleVal = new int[]{1, 3, 5};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 2);
        int[] expected = new int[]{3, 5};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysFiveValuesKTwo() {
        int[] singleVal = new int[]{1, 3, 5, 3, 1};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 2);
        int[] expected = new int[]{3, 5, 5, 3};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysFiveValuesKThree() {
        int[] singleVal = new int[]{1, 3, 5, 3, 1};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 3);
        int[] expected = new int[]{5, 5, 5};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSixValuesKTwo() {
        int[] singleVal = new int[]{1, 3, 5, 3, 1, 9};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 2);
        int[] expected = new int[]{3, 5, 5, 3, 9};

        assertArrayEquals(expected, result);
    }

    @Test
    public void getMaxSubArraysSixValuesKFour() {
        int[] singleVal = new int[]{1, 3, 5, 3, 1, 9};
        int[] result = MaxSubArray.getMaxSubArrays(singleVal, 4);
        int[] expected = new int[]{5, 5, 9};

        assertArrayEquals(expected, result);
    }
}