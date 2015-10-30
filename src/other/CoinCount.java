package other;

import java.util.Arrays;

public class CoinCount {

	public static void main(String[] args) {
			
		System.out.println(count(10,new int[]{2,3,5,6}));
		System.out.println(findCombinationsCount(10,new int[]{2,3,5,6}));

	}

	//wrong, duplicate solution
	public static int count(int n, int[] coins){
		
		int[] result = new int[n+1];
		
		result[0] = 1;
		
		for(int i=1;i<=n;i++){
			for(int coin : coins){
				if(i<coin){continue;}
				result[i] += result[i-coin];
			}
		}
		System.out.println(Arrays.toString(result));
		return result[n];
	}
	
	public static int findCombinationsCount(int sum, int vals[]) {
        if (sum < 0) {
            return 0;
        }
        if (vals == null || vals.length == 0) {
            return 0;
        }

        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < vals.length; ++i) {
            for (int j = vals[i]; j <= sum; ++j) {
                dp[j] += dp[j - vals[i]];
            }
        }
        return dp[sum];
    }
}
