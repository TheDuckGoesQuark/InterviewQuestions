package main.findnonduplicatedinteger;

/**
 * Given an array of integers where every integer occurs three times except for one integer,
 * which only occurs once, find and return the non-duplicated integer.
 * <p>
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
 * <p>
 * Do this in O(N) time and O(1) space.
 */
public class NonDuplicateDetector {

    public static int findNonDuplicate(int[] arr) {
        int ones = 0; // count of elements that have appeared once
        int twos = 0; // count of elements that have appeared twice

        for (int val : arr) {
            twos |= (ones & val);
            ones ^= val;

            int commonBitsMask = ~(ones & twos);
            ones &= commonBitsMask;
            twos &= commonBitsMask;
        }

        return ones;
    }

}
