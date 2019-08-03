package main.maxsubarray;

import java.util.LinkedList;

/**
 * Given an array of integers and a number k, where 1 <= k <= length of the array,
 * compute the maximum values of each subarray of length k.
 * <p>
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 * <p>
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 * <p>
 * Do this in O(n) time and O(k) space.
 * <p>
 * You can modify the input array in-place and you do not need to store the results.
 * You can simply print them out as you compute them
 */
public class MaxSubArray {

    public static int[] getMaxSubArrays(int[] arr, int k) {
        if (arr.length == 0) return new int[0];

        int numSubArrays = k < arr.length ? (arr.length - k) + 1 : 1;
        int[] results = new int[numSubArrays];

        LinkedList<Integer> dequeue = new LinkedList<>();

        // initial window
        int startIndex = 0;
        for (int i = 0; i < k && i < arr.length; i++) {
            addToDequeue(dequeue, arr, startIndex, i);
        }

        // Store first answer
        storeMax(arr, results, startIndex, dequeue);
        startIndex++;

        // the rest
        for (int endIndex = k; endIndex < arr.length; startIndex++, endIndex++) {
            addToDequeue(dequeue, arr, startIndex, endIndex);
            storeMax(arr, results, startIndex, dequeue);
        }

        return results;
    }

    /**
     * Records the current maximum of the sliding window in results
     *
     * @param values     array of values
     * @param results    array to store results in
     * @param startIndex index to store result at
     * @param indices    current dequeue of maximum values in the window
     */
    private static void storeMax(int[] values, int[] results, int startIndex, LinkedList<Integer> indices) {
        results[startIndex] = values[indices.getFirst()];
    }

    /**
     * Adds the given {@code endIndex} to {@code dequeue}. The order of the dequeue is maintained such that
     * 1. each index in the queue points to a value that is greater than the values at the indices to the right of it
     * 2. indices in the queue that are less than the start index are discarded
     *
     * @param dequeue    dequeue of indicies of the values in @{code values}
     * @param values     array of values
     * @param startIndex start of current sliding window
     * @param endIndex   end of sliding window
     */
    private static void addToDequeue(LinkedList<Integer> dequeue, int[] values, int startIndex, int endIndex) {
        // Remove elements that are no longer part of window
        while (!dequeue.isEmpty() && dequeue.getFirst() < startIndex) {
            dequeue.removeFirst();
        }

        // repeat: if (value at index to left is less than new value, remove it)
        while (dequeue.size() > 0 && values[dequeue.getLast()] < values[endIndex]){
            dequeue.removeLast();
        }
        dequeue.addLast(endIndex);
    }
}
