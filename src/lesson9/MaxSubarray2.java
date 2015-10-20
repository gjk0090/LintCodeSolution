package lesson9;

import java.util.*;

public class MaxSubarray2 {

	public static void main(String[] args) {

		System.out.println(maxTwoSubArrays(Arrays.asList(1, 3, -1, 2, -1, 2)));
	}
    public static int maxTwoSubArrays(List<Integer> nums) {
    	
    	int size = nums.size();
    	int[] left = new int[size];
    	int[] right = new int[size];
    	
    	//build left[], O(n)
    	int sum=0, minSum=0, maxSum=Integer.MIN_VALUE;
    	for(int i=0;i<size;i++){
    		sum+=nums.get(i);
    		maxSum = Math.max(maxSum, sum-minSum);
    		left[i] = maxSum;
    		minSum = Math.min(minSum, sum);
    	}
    	
    	//build right[]
    	sum=0; minSum=0; maxSum=Integer.MIN_VALUE;
    	for(int i=size-1;i>=0;i--){
    		sum+=nums.get(i);
    		maxSum = Math.max(maxSum, sum-minSum);
    		right[i] = maxSum;
    		minSum = Math.min(minSum, sum);
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for(int i=0;i<size-1;i++ ){
    		max = Math.max(max, left[i]+right[i+1]);
    	}
    	
		return max;
    }
}
