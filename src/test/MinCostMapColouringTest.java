package test;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static main.mapcolouring.MinCostMapColouring.getMinimumCost;

public class MinCostMapColouringTest {
    @Test
    public void getMinimumCostNoHouses() {
        int[][] input = new int[][]{};
        int expected = 0;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostOneHouseOneColour() {
        int[][] input = new int[][]{{1}};
        int expected = 1;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostOneHouseTwoColours() {
        int[][] input = new int[][]{{1, 2}};
        int expected = 1;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostOneHouseTwoColoursCheapestLast() {
        int[][] input = new int[][]{{2, 1}};
        int expected = 1;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostTwoHousesSamePrice() {
        int[][] input = new int[][]{{1, 2}, {1, 2}};
        int expected = 3;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostThreeHousesSamePrice() {
        int[][] input = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        int expected = 4;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostFourHousesSamePrice() {
        int[][] input = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}};
        int expected = 7;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostFourHousesThreeColoursSamePrice() {
        int[][] input = new int[][]{{1, 2, 1}, {1, 2, 1}, {1, 2, 1}, {1, 2, 1}};
        int expected = 5;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }

    @Test
    public void getMinimumCostFourHousesThreeColoursDifferentPrices() {
        int[][] input = new int[][]{{2, 2, 1}, {2, 2, 1}, {1, 2, 1}, {2, 2, 1}};
        int expected = 5;
        int actual = getMinimumCost(input);

        assertEquals(expected, actual);
    }
}
