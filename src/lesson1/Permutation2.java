package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(2);
		Collections.sort(input);
		
		ArrayList<ArrayList<Integer>> result = permute((ArrayList<Integer>) input);
		System.out.println(result.size());
		
		List<List<Integer>> result2 = permute(new int[]{1,2,2});

	}
	
	 public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
	        
	        ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>>();
	        if(nums == null){
	            return result;
	        }
	        List<Integer> permutation = new ArrayList<Integer>();
	       	helper(result, nums ,permutation);
	       	return result;
	    }
	       
	    public static void helper(ArrayList<ArrayList<Integer>> result, List<Integer> input,  List<Integer> permutation ) {
	        
	    	if(input.size() == 0){
	    		result.add(new ArrayList<Integer>(permutation)); //remember to copy list
	    		//System.out.println(permutation);
	    	}
	       	for(int i = 0; i < input.size(); i++){
	       		
	       		if(i > 0 && input.get(i)==input.get(i-1)){
	       		}else{
		       		permutation.add(input.get(i));
		       		
		       		//remove the element and copy to new list
		       		List<Integer> tempInput = new ArrayList<Integer>(input);
		       		tempInput.remove(i);
		       		
		       		helper(result, tempInput, permutation); 
		       		permutation.remove(permutation.size()-1);
	       		}
	       	}
	   	
	   	
	    }
	    
	    
	    
	    
	    // array version
	    
	    public static List<List<Integer>> permute(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> result = new ArrayList<>();
	        List<Integer> curr = new ArrayList<>();
	        boolean[] visited = new boolean[nums.length];
	        re(result,curr,nums,visited);
	        
	        return result;
	    }
	    
	    private static void re(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] visited){
	        if(curr.size() == nums.length){
	            result.add(new ArrayList<Integer>(curr));
	            //System.out.println(curr);
	        }
	        
	        for(int i=0; i<nums.length; i++){
	        	//if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){continue;}
	            if(!visited[i] && !(i>0 && nums[i] == nums[i-1] && !visited[i-1])){
	                curr.add(nums[i]);
	                visited[i]=true;
	                re(result,curr,nums,visited);
	                curr.remove(curr.size()-1);
	                visited[i]=false;
	            }
	        }
	    }

}
