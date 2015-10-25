package lesson8;

import java.util.*;
import java.util.Queue;

import util.ListNode;


public class DataStreamMedian {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(medianII(new int[]{4, 5, 1, 3, 2, 6, 0})));
		System.out.println(Arrays.toString(medianII(new int[]{1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(medianII(new int[]{2, 20, 100})));
	}
    public static int[] medianII(int[] nums) {

        Queue<Integer> minHeap = new PriorityQueue<Integer>((Integer n1, Integer n2)->{
    		return n1 - n2;
    	});
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((Integer n1, Integer n2)->{
    		return n2 - n1;
    	});

        int[] result = new int[nums.length];
        result[0] = nums[0];
        int median = nums[0];
        
        for(int i=1;i<nums.length;i++){ //start from 1
        	if(nums[i]<median){
        		maxHeap.offer(nums[i]);
        	}else{
        		minHeap.offer(nums[i]);
        	}
        	
        	int leftSize = maxHeap.size();
        	int rightSize = minHeap.size();
        	
        	if(leftSize > rightSize){ //left11 right10 change
        		minHeap.offer(median);
        		median = maxHeap.poll();
        	}
        	
        	if(rightSize > leftSize+1){ //left10 tright11 OK
        		maxHeap.offer(median);
        		median = minHeap.poll();
        	}
        	
        	result[i] = median;
        }
        
        
		return result;
    }
}
