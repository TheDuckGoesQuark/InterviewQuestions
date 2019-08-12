package test;

import main.streammedian.StreamMedian;
import org.junit.Test;

import static org.junit.Assert.*;

public class StreamMedianTest {

    @Test
    public void getRollingMedian() {
        assertEquals(new double[]{}, StreamMedian.getRollingMedian(new double[]{}));
        assertEquals(new double[]{2}, StreamMedian.getRollingMedian(new double[]{2}));
        assertEquals(new double[]{2, 1.5}, StreamMedian.getRollingMedian(new double[]{2, 1}));
        assertEquals(new double[]{2, 1.5, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5}));
        assertEquals(new double[]{2, 1.5, 2, 3.5}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7}));
        assertEquals(new double[]{2, 1.5, 2, 3.5, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7, 2}));
        assertEquals(new double[]{2, 1.5, 2, 3.5, 2, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7, 2, 0}));
        assertEquals(new double[]{2, 1.5, 2, 3.5, 2, 2, 2}, StreamMedian.getRollingMedian(new double[]{2, 1, 5, 7, 2, 0, 5}));
    }

}