package main.overlappingintervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.
 * <p>
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class OverlappingIntervals {

    /**
     * Find the minimum number of rooms required to allow each interval period to run
     *
     * @param startFinishPairs array of integer pairs representing (start,finish) time
     * @return Find the minimum number of rooms required to allow each interval period to run
     */
    public static int getMinNumberOfRoomsRequired(int[][] startFinishPairs) {
        // Create interval instances and sort by start time O(n log(n))
        Interval[] intervals = Arrays.stream(startFinishPairs)
                .map(Interval::new)
                .sorted(Comparator.comparingInt(Interval::getStartTime))
                .toArray(Interval[]::new);

        int maxConflicts = 0;
        for (int i = 0; i < intervals.length; i++) {
            Interval current = intervals[i];

            for (int j = i + 1; j < intervals.length; j++) {
                Interval comparedTo = intervals[j];

                if (comparedTo.getStartTime() >= current.getEndTime())
                    break;
                else {
                    comparedTo.incrementConflictingCount();
                }
            }

            if (current.getConflictingCount() > maxConflicts)
                maxConflicts = current.getConflictingCount();
        }

        return maxConflicts + 1;
    }
}
