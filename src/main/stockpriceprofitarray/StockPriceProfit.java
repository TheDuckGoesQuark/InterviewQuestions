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
        if (prices == null || prices.length <= 1)
            return 0;

        int maxProfit = 0;
        int currentBuy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            int profit = price - currentBuy;

            if (profit > maxProfit)
                maxProfit = profit;

            if (price < currentBuy)
                currentBuy = price;
        }

        return maxProfit;
    }

}
