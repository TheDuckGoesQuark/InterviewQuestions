package interview;

import interview.staircase.StaircaseClimbingPermutations;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaircaseClimbingPermutationsTests {

    @Test
    public void countUniqueWaysToClimbWithSteps() {
        assertEquals(1, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(0, new int[]{1, 2}));
        assertEquals(1, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(1, new int[]{1, 2}));
        assertEquals(2, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(2, new int[]{1, 2}));
        assertEquals(3, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(3, new int[]{1, 2}));
        assertEquals(5, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(4, new int[]{1, 2}));
        assertEquals(8, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(5, new int[]{1, 2}));
        assertEquals(13, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(6, new int[]{1, 2}));
        assertEquals(21, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(7, new int[]{1, 2}));

        assertEquals(1, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(0, new int[]{1, 3}));
        assertEquals(1, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(1, new int[]{1, 3}));
        assertEquals(1, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(2, new int[]{1, 3}));
        assertEquals(2, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(3, new int[]{1, 3}));
        assertEquals(3, StaircaseClimbingPermutations.countUniqueWaysToClimbUsingSteps(4, new int[]{1, 3}));
    }
}