package interview;

import interview.nqueens.NQueens;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Inputs and outputs sourced from https://en.wikipedia.org/wiki/Eight_queens_puzzle
 */
public class NQueensTest {
    @Test
    public void getNumberOfPossibleArrangementsNOne() {
        assertEquals(1, NQueens.getNumberOfPossibleArrangements(1));
    }

    @Test
    public void getNumberOfPossibleArrangementsNTwo() {
        assertEquals(0, NQueens.getNumberOfPossibleArrangements(2));
    }

    @Test
    public void getNumberOfPossibleArrangementsNThree() {
        assertEquals(0, NQueens.getNumberOfPossibleArrangements(3));
    }

    @Test
    public void getNumberOfPossibleArrangementsNFour() {
        assertEquals(2, NQueens.getNumberOfPossibleArrangements(4));
    }

    @Test
    public void getNumberOfPossibleArrangementsNFive() {
        assertEquals(10, NQueens.getNumberOfPossibleArrangements(5));
    }

    @Test
    public void getNumberOfPossibleArrangementsNSix() {
        assertEquals(4, NQueens.getNumberOfPossibleArrangements(6));
    }

    @Test
    public void getNumberOfPossibleArrangementsNSeven() {
        assertEquals(40, NQueens.getNumberOfPossibleArrangements(7));
    }

    @Test
    public void getNumberOfPossibleArrangementsNEight() {
        assertEquals(92, NQueens.getNumberOfPossibleArrangements(8));
    }

    @Test
    public void getNumberOfPossibleArrangementsNNine() {
        assertEquals(352, NQueens.getNumberOfPossibleArrangements(9));
    }

    @Test
    public void getNumberOfPossibleArrangementsNTen() {
        assertEquals(724, NQueens.getNumberOfPossibleArrangements(10));
    }
}