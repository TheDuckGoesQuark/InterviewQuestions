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
        Interval[] intervals = (Interval[]) Arrays.stream(startFinishPairs)
                .map(Interval::new)
                .sorted(Comparator.comparingInt(Interval::getStartTime))
                .toArray();

        // For each interval, increment conflict count for that interval and the conflicting intervals
        // Since sorted by start time, we only need to check ahead until the this.endtime < next.starttime
        // Best case: O(n) (only need to check ahead by one for each, so 2n, no conflicts)
        // Worst case O(n^2) (need to check entire rest of list for each, so (n + n-1 + ... 1) = O(n^2)
        int maxConflicts = 0;
        for (int i = 0; i < intervals.length; i++) {
            Interval current = intervals[i];

            for (int j = i + 1; j < intervals.length; j++) {
                Interval comparedTo = intervals[j];

                if (comparedTo.getStartTime() >= current.getEndTime())
                    break;
                else {
                    current.incrementConflictingCount();
                    comparedTo.incrementConflictingCount();
                }
            }

            if (current.getConflictingCount() > maxConflicts)
                maxConflicts = current.getConflictingCount();
        }

        return maxConflicts + 1;
    }
}
