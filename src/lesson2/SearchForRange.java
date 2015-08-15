package lesson2;

import java.util.ArrayList;
import java.util.Arrays;

import util.PrintUtil;
/**
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * Challenge
 * O(log n) time.
 * @author gjk
 *
 */
public class SearchForRange {

	public static void main(String[] args) {
		ArrayList<Integer> A;
		A = new ArrayList<Integer>( Arrays.asList(new Integer[] {1,2,3,4,5,5,5,6,7,8,9}));
		
		
		PrintUtil.printList(searchRange2(A,9));
		
	}
	
    public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
    	
    	if(A == null || A.size() == 0){
    		return new ArrayList<Integer> (Arrays.asList(new Integer[] {-1,-1}));
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	// first occur
    	int start = 0;
    	int end = A.size() - 1;
    	
    	while(start + 1 < end){
    		int middle = start + (end - start)/2;
    		
    		if(A.get(middle) == target){
    			end = middle;
    		}else if(A.get(middle) > target){
    			end = middle;
    		}else{
    			start = middle;
    		}
    	}
    	
    	if(A.get(start) == target){
    		result.add(start);
    	}else if(A.get(end) == target){
    		result.add(end);
    	}else{
    		return new ArrayList<Integer> (Arrays.asList(new Integer[] {-1,-1}));
    	}

    	//last occur
    	start = 0;
    	end = A.size() - 1;
    	
    	while(start + 1 < end){
    		int middle = start + (end - start)/2;
    		
    		if(A.get(middle) == target){
    			start = middle;
    		}else if(A.get(middle) > target){
    			end = middle;
    		}else{
    			start = middle;
    		}
    	}
    	
    	if(A.get(end) == target){
    		result.add(end);
    	}else if(A.get(start) == target){
    		result.add(start);
    	}else{
    		return new ArrayList<Integer> (Arrays.asList(new Integer[] {-1,-1}));
    	}

    	return result;
    }
    
    
    
    public static ArrayList<Integer> searchRange2(ArrayList<Integer> A, int target) {
    	
    	if(A == null || A.size() == 0){
    		return new ArrayList<Integer> (Arrays.asList(new Integer[] {-1,-1}));
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	int start = 0;
    	int end = A.size() - 1;
    	int middle = start + (end - start)/2;
    	    	
    	// find any occur
    	while(start + 1 < end){
    		middle = start + (end - start)/2;
    		
    		if(A.get(middle) < target){
    			start = middle;
    		}else if(A.get(middle) > target){
    			end = middle;
    		}else{ //A.get(middle) == target
    			break;
    		}
    	}
    	
    	if(A.get(end) == target){
    		middle = end;
    	}else if(A.get(start) == target){
    		middle = start;
    	}

    	
    	if(A.get(middle) == target){
    		int newEnd = middle;
    		int newStart = middle;
    		
    		// find first occur
    		while(start + 1 < newEnd){
        		middle = start + (newEnd - start)/2;
        		
        		if(A.get(middle) == target){
        			newEnd = middle;
        		}else if(A.get(middle) > target){
        			newEnd = middle;
        		}else{
        			start = middle;
        		}
        	}
    		
        	if(A.get(start) == target){
        		result.add(start);
        	}else if(A.get(newEnd) == target){
        		result.add(newEnd);
        	}
    		
        	// find last occur
    		while(newStart + 1 < end){ 
        		middle = newStart + (end - newStart)/2;
        		
        		if(A.get(middle) == target){
        			newStart = middle; 
        		}else if(A.get(middle) > target){
        			end = middle;
        		}else{
        			newStart = middle;
        		}
        	}
    		
        	if(A.get(end) == target){
        		result.add(end);
        	}else if(A.get(newStart) == target){
        		result.add(newStart);
        	}

    		
    	}else{
    		return new ArrayList<Integer> (Arrays.asList(new Integer[] {-1,-1}));
    	}
    	
    	return result;
    }

}
