package algorithms.medium;

/* Say you have an array for which the ith element is the price of a given stock on day i. 
 * If you were only permitted to complete at most one transaction (i.e., 
 * buy one and sell one share of the stock), design an algorithm to find the maximum profit. */

public class _20150916_BestTimeToBuyAndSellStock_revisit {
	public static int maxProfit(int[] prices) {
		if(prices.length == 0){
			return 0;
		}
		int maxProfit = 0;
		int min = prices[0];
		for(int i = 1; i < prices.length; i++){
			if(min > prices[i]){
				min = prices[i];
			}
		maxProfit = Math.max(prices[i] - min, maxProfit);
		}		
		return maxProfit;
	}
	public static void main(String args[]){
		int [] p = new int[]{1, 2, 9};
		System.out.println(maxProfit(p));
	}
}
