package main.mapcolouring;

/**
 * A builder is looking to build a row of N houses that can be of K different colors.
 * He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 * <p>
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
 */
public class MinCostMapColouring {

    /**
     * Simple:
     * Try each permutation, return cheapest
     */
    public static int getMinimumCost(int[][] houseColourCosts) {
        return recursiveCosts(houseColourCosts, 0, -1);
    }

    private static int recursiveCosts(int[][] houseColourCosts, int rowIndex, int disallowedColIndex) {
        if (rowIndex == houseColourCosts.length) return 0;

        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < houseColourCosts[0].length; i++) {
            if (i == disallowedColIndex) continue;

            int colCost = houseColourCosts[rowIndex][i];

            int cost = colCost + recursiveCosts(houseColourCosts, rowIndex + 1, i);
            if (cost < currentMin) currentMin = cost;
        }

        return currentMin;
    }
}
