package main.stockpriceprofitarray;

/**
 * Given an array of numbers representing the stock prices of a company in chronological order write a
 * function that calculates the maximum profit you could have made from buying and selling that stock once.
 * <p>
 * You must buy before you can sell it.
 * <p>
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars
 * and sell it at 10 dollars.
 */
public class StockPriceProfit {

    public static int mostProfitFromPrices(int[] prices) {
        // naive
        // for each number, check biggest diff of all numbers ahead of it
        int biggestDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];

                if (sell > buy && sell - buy > biggestDiff)
                    biggestDiff = sell - buy;
            }
        }

        return biggestDiff;
    }

}
