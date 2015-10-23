package lesson8;

import java.util.*;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));

	}
    public static int largestRectangleArea(int[] height) {
    	
    	int[] left = new int[height.length]; //first number to the left that is smaller then i
    	int[] right = new int[height.length];
    	
    	//compute left
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for(int i=0;i<height.length;i++){
    		//pop every number greater than self
    		while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
    			stack.pop();
    		}
    		//record top number in stack
    		if(!stack.isEmpty()){
    			left[i] = stack.peek();
    		}else{
    			left[i] = -1;
    		}
    		//push self
    		stack.push(i);
    		
    	}
    	
    	//compute right
    	stack = new Stack<Integer>();
    	
    	for(int i=height.length-1;i>=0;i--){
    		//pop every number greater than self
    		while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
    			stack.pop();
    		}
    		//record top number in stack
    		if(!stack.isEmpty()){
    			right[i] = stack.peek();
    		}else{
    			right[i] = height.length; //not -1
    		}
    		//push self
    		stack.push(i);
    		
    	}
    	
    	//compute max
    	int max = 0;
    	for(int i=0;i<height.length;i++){
    		max = Math.max(max, height[i]*(right[i]-left[i]-1));
       	}
    	
    	//System.out.println(Arrays.toString(left));
    	//System.out.println(Arrays.toString(right));
    	
		return max;
    }
    
    
    
    
    public int largestRectangleArea2(int[] height) {
        int max = 0;
    	for(int i=0;i<height.length;i++){
    	    for(int j=i;j<height.length;j++){
    	        int minHeight = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    minHeight = Math.min(minHeight,height[k]);
                }
                max = Math.max(max,minHeight*(j-i+1));
    	        
    	        
    	    } 
    	    
    	    
    	}
    	return max;
    }
}
