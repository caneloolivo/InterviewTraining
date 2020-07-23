package Amazon;

public class FinalPricesWithASpecialDiscountInaShop {
	public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        int lower = prices[n-1];
        for(int i = n-1; i>-1; i--) {
        	int desc = 0;
        	if(lower < prices[i])
        		desc = lower;
        	result[i] = prices[i]- desc;
        	lower = Math.min(lower, prices[i]);
        }
        return result;
    }
	
	public static void main(String[] args) {
		FinalPricesWithASpecialDiscountInaShop solution = new FinalPricesWithASpecialDiscountInaShop();
		int[] prices = {8,4,6,2,3};
		int [] result = solution.finalPrices(prices);
		for(int num: result) 
			System.out.print(num + " ");
	}
}
