package interview.stonepyramid;

import java.util.Arrays;

/**
 * You have N stones in a row, and would like to create from them a pyramid.
 * This pyramid should be constructed such that the height of each stone increases by one until reaching the tallest stone, after which the heights decrease by one.
 * In addition, the start and end stones of the pyramid should each be one stone high.
 * <p>
 * You can change the height of any stone by paying a cost of 1 unit to lower its height by 1, as many times as necessary.
 * Given this information, determine the lowest cost method to produce this pyramid.
 * <p>
 * For example, given the stones [1, 1, 3, 3, 2, 1],
 * the optimal solution is to pay 2 to create [0, 1, 2, 3, 2, 1].
 */
public class StonePyramidBuilder {

    private static int[] getAdjustmentsForIndexToBeCenter(int centerIndex, int[] stones) {
        if (stones.length == 1) {
            return new int[]{stones[0] - 1};
        }

        var initialHeight = stones[centerIndex];
        var stonesToTheRight = (stones.length - 1) - centerIndex;
        var maxHeight = Math.min(initialHeight, Math.min(centerIndex + 1, stonesToTheRight + 1));
        var adjustments = new int[stones.length];
        // initialise adjustments so that center stone is maximum possible height
        adjustments[centerIndex] = stones[centerIndex] - maxHeight;

        for (int i = 1; i <= centerIndex; i++) {
            var currentStoneIndex = centerIndex - i;
            var centerHeight = stones[centerIndex] - adjustments[centerIndex];
            var requiredHeight = Math.max(centerHeight - i, 0);

            // decrease entire pyramid so this stone can be part of it
            if (requiredHeight > stones[currentStoneIndex]) {
                var difference = requiredHeight - stones[currentStoneIndex];
                // only adjust up to center since we haven't changed right hand side yet
                for (int j = 0; j < i; j++) {
                    var adjustmentIndex = centerIndex - j;
                    var newAdjustment = adjustments[adjustmentIndex] + difference;
                    adjustments[adjustmentIndex] = newAdjustment;
                }
            } else {
                adjustments[currentStoneIndex] = stones[currentStoneIndex] - requiredHeight;
            }
        }

        for (int i = 1; i <= stonesToTheRight; i++) {
            var currentStoneIndex = centerIndex + i;
            var centerHeight = stones[centerIndex] - adjustments[centerIndex];
            var requiredHeight = Math.max(centerHeight - i, 0);

            // decrease entire pyramid so this stone can be part of it
            if (requiredHeight > stones[currentStoneIndex]) {
                var difference = requiredHeight - stones[currentStoneIndex];
                // adjust whole left side and center
                for (int j = 0; j <= centerIndex; j++) {
                    var adjustmentIndex = centerIndex - j;
                    var newAdjustment = adjustments[adjustmentIndex] + difference;

                    // adjustment index shouldnt cause the stone to be negative size
                    adjustments[adjustmentIndex] = stones[adjustmentIndex] - newAdjustment < 0
                            ? stones[adjustmentIndex]
                            : newAdjustment;
                }

                // adjust up to this stone on right side
                for (int j = 0; j < i; j++) {
                    var adjustmentIndex = centerIndex + j;
                    var newAdjustment = adjustments[adjustmentIndex] + difference;
                    adjustments[adjustmentIndex] = newAdjustment;
                }
            } else {
                adjustments[currentStoneIndex] = stones[currentStoneIndex] - requiredHeight;
            }
        }
        return adjustments;
    }

    public static int lowestCostToBuildPyramidFromStones(int[] stones) {
        // for each element
        // treat as centre of pyramid
        // iterate out left and right to determine total cost for this to be center
        // take cheapest total cost
        var minCost = Integer.MAX_VALUE;

        for (int centerIndex = 0; centerIndex < stones.length; centerIndex++) {
            // initial cost is whatever it would take to reduce current to max allowable
            // calculated by distance to edges
            var finalCost = 0;
            var adjustments = getAdjustmentsForIndexToBeCenter(centerIndex, stones);
            System.out.println(Arrays.toString(adjustments));
            for (int adjustment : adjustments) {
                finalCost += adjustment;
            }

            if (finalCost < minCost) {
                minCost = finalCost;
            }
        }

        return minCost;
    }
}
