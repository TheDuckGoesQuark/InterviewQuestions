package main.overlappingintervals;

class Interval {

    private final int[] interval;
    private int conflictingCount;

    Interval(int[] interval) {
        this.interval = interval;
    }

    int getStartTime() {
        return interval[0];
    }

    int getEndTime() {
        return interval[1];
    }

    int getConflictingCount() {
        return conflictingCount;
    }

    void incrementConflictingCount() {
        conflictingCount++;
    }
}
