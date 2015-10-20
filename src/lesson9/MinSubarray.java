package lesson9;

import java.util.List;

public class MinSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int minSubArray(List<Integer> nums) {

        int sum=0, maxSum=0, minSum=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.size();i++){
            sum+=nums.get(i);
            minSum = Math.min(minSum,sum-maxSum);
            maxSum = Math.max(maxSum,sum);
        }
        return minSum;
    }
}
