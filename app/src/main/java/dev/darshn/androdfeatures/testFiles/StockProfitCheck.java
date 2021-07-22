package dev.darshn.androdfeatures.testFiles;


/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */

class StockProfitCheck {
    public void checkPrice(){
        int[] prices = {1,2,3,4,5};
        int totalProfit = 0;

        for (int j = 0; j < prices.length-1; j++) {
            if(prices[j]<prices[j+1]){
                totalProfit +=  prices[j+1]-prices[j];
            }
        }
      System.out.println(totalProfit);

    }
}
