package test;

import main.overlappingintervals.OverlappingIntervals;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverlappingIntervalsTest {

    @Test
    public void getMinNumberOfRoomsRequiredTestOneConflict() {
        int[][] input = new int[][]{{30, 75}, {0, 50}, {60, 150}};
        int expected = 2;

        assertEquals(expected, OverlappingIntervals.getMinNumberOfRoomsRequired(input));
    }

    @Test
    public void getMinNumberOfRoomsRequiredTestNoConflicts() {
        int[][] input = new int[][]{{0, 25}, {25, 50}, {60, 150}};
        int expected = 1;

        assertEquals(expected, OverlappingIntervals.getMinNumberOfRoomsRequired(input));
    }

    @Test
    public void getMinNumberOfRoomsRequiredTestTwoConflicts() {
        int[][] input = new int[][]{{0, 25}, {0, 25}, {0, 30}};
        int expected = 3;

        assertEquals(expected, OverlappingIntervals.getMinNumberOfRoomsRequired(input));
    }
}