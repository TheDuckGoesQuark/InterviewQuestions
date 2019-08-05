package main.overlappingintervals;

class Interval {

    private int[] interval;
    private int conflictingCount = 0;

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
