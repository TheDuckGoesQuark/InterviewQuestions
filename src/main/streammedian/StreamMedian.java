package main.streammedian;

/**
 * Compute the running median of a sequence of numbers.
 * That is, given a stream of numbers, print out the median of the list so far on each new element.
 * <p>
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * <p>
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 * <p>
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 */
public class StreamMedian {

    public static double[] getRollingMedian(double[] sequence) {
        final double[] result = new double[sequence.length];
        final Heap<Double> lowHeap = new Heap<>(true);
        final Heap<Double> highHeap = new Heap<>(false);

        for (int i = 0; i < sequence.length; i++) {

        }

        return result;
    }

}
