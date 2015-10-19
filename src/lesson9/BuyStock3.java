package lesson9;

public class BuyStock3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[]{1,2}));
	}
	
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for(int i=0;i<prices.length;i++){//where to split
            int profit1=0, min1=prices[0];
            for(int j=0;j<i;j++){
                profit1 = Math.max(profit1,prices[j]-min1);
                min1 = Math.min(min1,prices[j]);
            }
            int profit2=0, min2=prices[i];
            for(int j=i;j<prices.length;j++){
                profit2 = Math.max(profit2,prices[j]-min2);
                min2 = Math.min(min2,prices[j]);
            }
            
            maxProfit = Math.max(maxProfit, profit1+profit2);
        }

        return maxProfit;
    }
}
