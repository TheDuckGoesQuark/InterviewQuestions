package test;

import main.streammedian.Heap;
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

    @Test
    public void heapTest() {
        final Heap<Integer> minHeap = new Heap<>(false);
        minHeap.add(0);
        assertEquals(0, minHeap.getRoot().intValue());

        minHeap.add(1);
        assertEquals(0, minHeap.getRoot().intValue());

        minHeap.add(2);
        assertEquals(0, minHeap.getRoot().intValue());

        minHeap.removeRoot();
        assertEquals(1, minHeap.getRoot().intValue());

        final Heap<Integer> maxHeap = new Heap<>(true);
        maxHeap.add(0);
        assertEquals(0, maxHeap.getRoot().intValue());

        maxHeap.add(1);
        assertEquals(1, maxHeap.getRoot().intValue());

        maxHeap.add(2);
        assertEquals(2, maxHeap.getRoot().intValue());

        maxHeap.removeRoot();
        assertEquals(1, maxHeap.getRoot().intValue());
    }

}