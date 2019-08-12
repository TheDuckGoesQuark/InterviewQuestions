package test;

import main.streammedian.StreamMedian;
import org.junit.Test;

import static org.junit.Assert.*;

public class StreamMedianTest {

    @Test
    public void getRollingMedian() {
        assertArrayEquals(new double[]{}, StreamMedian.getRollingMedian(new double[]{}), 0.1);
        assertArrayEquals(new double[]{2}, StreamMedian.getRollingMedian(new double[]{2}), 0.1);
        assertArrayEquals(new double[]{2, 1.5}, StreamMedian.getRollingMedian(new double[]{2, 1}), 0.1);
        assertArrayEquals(new double[]{2, 1.5, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5}), 0.1);
        assertArrayEquals(new double[]{2, 1.5, 2, 3.5}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7}), 0.1);
        assertArrayEquals(new double[]{2, 1.5, 2, 3.5, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7, 2}), 0.1);
        assertArrayEquals(new double[]{2, 1.5, 2, 3.5, 2, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7, 2, 0}), 0.1);
        assertArrayEquals(new double[]{2, 1.5, 2, 3.5, 2, 2, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7, 2, 0, 5}), 0.1);
    }

}