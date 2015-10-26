package algorithms.medium;

/* Say you have an array for which the ith element is the price 
 * of a given stock on day i. Design an algorithm to find the 
 * maximum profit. You may complete as many transactions as 
 * you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at 
 * the same time (ie, you must sell the stock before you buy again). */

/* Got ideas from online:
 * Use greedy algorithm for this problem, always seek for the local max number,
 * the number that is right next to the max is smaller than the max number while
 * all the numbers that are before this max are smaller than the max, we call this number
 * local max and sell the stock at this price, initially, we buy the stock at the lowest
 * price, indicated by the startIndex. 
 * On the way of calculating local max profit one by one, we add them up to the totalProfit. */

public class _20150916_BestTimeToBuyAndSellStockII_revisit {
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len == 0){
			return 0;
		}
//		System.out.println("len = " + len);
		int currentMax = prices[0];
		int currentMin = prices[0];
		int currentProfit = 0;
		int totalProfit = 0;
		int i = 1, startIndex = 0, j;
		for(; i < len; i++){
			if(prices[i] < prices[i-1]){
				currentProfit = prices[i-1] - prices[startIndex];
				startIndex = i;
				totalProfit += currentProfit;
			}
	//		System.out.println("startIndex = " + startIndex);
		}
		if(prices[i-1] > prices[startIndex]){
			currentProfit = prices[i-1] - prices[startIndex];
			totalProfit += currentProfit;
		}
		return totalProfit;
	}
	public static void main(String args[]){
		int [] p = new int[]{1, 2};
		System.out.println(maxProfit(p));
	}
}
