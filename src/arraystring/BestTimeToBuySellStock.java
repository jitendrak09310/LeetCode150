package arraystring;

public class BestTimeToBuySellStock {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = findBestTimeToBuySellStock(prices);
		System.out.println(maxProfit);
	}

	public static int findBestTimeToBuySellStock(int prices[]) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (minPrice > prices[i]) {
				minPrice = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - minPrice);

			}
		}
		return maxProfit;
	}
}
