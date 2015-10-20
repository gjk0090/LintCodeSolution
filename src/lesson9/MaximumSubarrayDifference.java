package lesson9;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarrayDifference {

	public static void main(String[] args) {
		System.out.println(maxDiffSubArrays(Arrays.asList(1,2,-3,1)));

	}
	
	
    public static int maxDiffSubArrays(List<Integer> nums) {
    	int size = nums.size();
    	int[] leftMax = new int[size];
    	int[] leftMin = new int[size];
    	int[] rightMax = new int[size];
    	int[] rightMin = new int[size];
    	
    	int sum=0,minSum=0,maxSum=Integer.MIN_VALUE;
    	for(int i=0;i<size;i++){
    		sum+=nums.get(i);
    		maxSum = Math.max(maxSum,sum-minSum);
    		minSum = Math.min(minSum, sum);
    		leftMax[i]=maxSum;
    	}
    	
    	sum=0;minSum=Integer.MAX_VALUE;maxSum=0;
    	for(int i=0;i<size;i++){
    		sum+=nums.get(i);
    		minSum = Math.min(minSum,sum-maxSum);
    		maxSum = Math.max(maxSum, sum);
    		leftMin[i]=minSum;
    	}
    	
    	sum=0;minSum=0;maxSum=Integer.MIN_VALUE;
    	for(int i=size-1;i>=0;i--){
    		sum+=nums.get(i);
    		maxSum = Math.max(maxSum,sum-minSum);
    		minSum = Math.min(minSum, sum);
    		rightMax[i]=maxSum;
    	}
    	
    	sum=0;minSum=Integer.MAX_VALUE;maxSum=0;
    	for(int i=size-1;i>=0;i--){
    		sum+=nums.get(i);
    		minSum = Math.min(minSum,sum-maxSum);
    		maxSum = Math.max(maxSum, sum);
    		rightMin[i]=minSum;
    	}
    	
    	
    	int result = Integer.MIN_VALUE;
    	for(int i=0;i<size-1;i++){
    		result = Math.max(result, Math.abs(leftMax[i]-rightMin[i+1]));
    		result = Math.max(result, Math.abs(leftMin[i]-rightMax[i+1]));
    	}
    	
		return result;
    }
}
