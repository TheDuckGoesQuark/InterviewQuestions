package test.stockpriceprofitarray;

import main.stockpriceprofitarray.StockPriceProfit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class StockPriceProfitTest {

    private final int[] input;
    private final int expected;

    public StockPriceProfitTest(int[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][]{
                {new int[]{9, 11, 8, 5, 7, 10}, 5},
                {new int[]{0, 1}, 1},
                {new int[]{0}, 0},
                {new int[]{5, 1}, 0},
                {new int[]{5, 4, 2, 1, 10}, 9},
                {new int[]{5, 4, 1, 2, 10}, 9},
                {new int[]{5, 1, 5, 2, 10}, 9},
                {new int[]{1, 7, 5, 2, 10}, 9},
                {new int[]{9, 11, 8, 5, 7, 10, 4, 7}, 5},
                {new int[]{9, 11, 4, 6, 12}, 8},
                {new int[]{9, 11, 5, 6, 12}, 7},
                {new int[]{5, 11, 6, 6, 12}, 7},
        };

        return Arrays.asList(data);
    }

    @Test
    public void mostProfitFromPrices() {
        assertEquals(expected, StockPriceProfit.mostProfitFromPrices(input));
    }
}