package lesson9;

import java.util.*;

public class MaxSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//at least pick 1 element
    public int maxSubArray(List<Integer> nums) {
        int minSum=0, maxSum=Integer.MIN_VALUE, sum=0; //important
        for(int i=0;i<nums.size();i++){
            sum = sum+nums.get(i);
            maxSum = Math.max(maxSum, sum-minSum);
            minSum = Math.min(minSum, sum);
        }
        return maxSum;
    }
}
