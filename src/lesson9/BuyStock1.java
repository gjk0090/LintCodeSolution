package lesson9;

public class BuyStock1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2){return 0;}
        int profit = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++){
            int temp = prices[i]-min;
            profit = Math.max(profit,temp);
            min = Math.min(min,prices[i]);
        }
        
        return profit;
    }
}
