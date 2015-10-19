package lesson9;

public class BuyStock2 {

	public static void main(String[] args) {

		System.out.println(maxProfit(new int[]{1,2,333,334}));
	}
    public static int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            profit+=Math.max(0, prices[i+1]-prices[i]);
        }
        return profit;
    }

}
