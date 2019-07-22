package main.staircase;

import java.util.HashMap;
import java.util.Map;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * <p>
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class StaircaseClimbingPermutations {

    private static int recursivelyFindWaysToClimbUsingSteps(int current, int target, int[] allowedSteps, Map<Integer, Integer> memoizedBranches) {
        // Reached leaf node, increase number of branches
        if (current == target) return 1;
        else if (current > target) return 0;

        // Don't traverse further if already know number of branches from here
        if (memoizedBranches.containsKey(current)) {
            return memoizedBranches.get(current);
        }

        // Count number of ways to reach target for each next possible step size
        int branches = 0;
        for (int stepSize : allowedSteps) {
            branches += recursivelyFindWaysToClimbUsingSteps(current + stepSize, target, allowedSteps, memoizedBranches);
        }

        // Store number of branches to save traversing same branch later
        memoizedBranches.put(current, branches);

        return branches;
    }

    public static int countUniqueWaysToClimbUsingSteps(int nSteps, int[] allowedSteps) {
        final Map<Integer, Integer> memoizedBranches = new HashMap<>();
        return recursivelyFindWaysToClimbUsingSteps(0, nSteps, allowedSteps, memoizedBranches);
    }
}
