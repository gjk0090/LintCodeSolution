package lesson1;

import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		Collections.sort(input);
		
		ArrayList<ArrayList<Integer>> result = permute((ArrayList<Integer>) input);
		System.out.println(result.size());
		
		List<List<Integer>> result2 = permute2(new int[]{1,2,3});
		for (List<Integer> list : result2) {
			System.out.println(list);
		}

	}
	
	//list version
	
	 public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
	        
	        ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>>();
	        if(nums == null){
	            return result;
	        }
	        List<Integer> permutation = new ArrayList<Integer>();
	       	helper(result, nums ,permutation);
	       	
	       	//remove duplicate (permutation 2)
//	       	Set set = new HashSet(result);
//	       	result = new ArrayList(set);
	       	
	       	return result;
	    }
	       
	    public static void helper(ArrayList<ArrayList<Integer>> result, List<Integer> input,  List<Integer> permutation ) {
	        
	    	if(input.size() == 0){
	    		result.add(new ArrayList<Integer>(permutation)); //remember to copy list
	    		//System.out.println(permutation);
	    	}
	       	for(int i = 0; i < input.size(); i++){
	       		permutation.add(input.get(i));
	       		
	       		//remove the element and copy to new list
	       		List<Integer> tempInput = new ArrayList<Integer>(input);
	       		tempInput.remove(i);
	       		
	       		helper(result, tempInput, permutation); 
	       		permutation.remove(permutation.size()-1);
	       	}
	   	
	   	
	    }
	    
	    
	    
	    // array version
	    
	    public List<List<Integer>> permute(int[] nums) {
	        
	        List<List<Integer>> result = new ArrayList<>();
	        List<Integer> curr = new ArrayList<>();
	        boolean[] visited = new boolean[nums.length];
	        re(result,curr,nums,visited);
	        
	        return result;
	    }
	    
	    private void re(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] visited){
	        if(curr.size() == nums.length){
	            result.add(new ArrayList<Integer>(curr));
	        }
	        
	        for(int i=0; i<nums.length; i++){
	            if(!visited[i]){
	                curr.add(nums[i]);
	                visited[i]=true;
	                re(result,curr,nums,visited);
	                curr.remove(curr.size()-1);
	                visited[i]=false;
	            }
	        }
	    }
	    
	    
	    
	    
	    // array and addAll version
	    
	    public static List<List<Integer>> permute2(int[] nums) {
	        
	        List<List<Integer>> result = new ArrayList<>();
	        List<Integer> curr = new ArrayList<>();
	        boolean[] visited = new boolean[nums.length];
	        result.addAll(re(curr,nums,visited));
	        
	        return result;
	    }
	    
	    private static List<List<Integer>>  re(List<Integer> curr, int[] nums, boolean[] visited){
	    	
	    	List<List<Integer>> result = new ArrayList<>();
	    	
	        if(curr.size() == nums.length){
	            result.add(new ArrayList<Integer>(curr));
	        }
	        
	        for(int i=0; i<nums.length; i++){
	            if(!visited[i]){
	                curr.add(nums[i]);
	                visited[i]=true;
	                result.addAll(re(curr,nums,visited));
	                curr.remove(curr.size()-1);
	                visited[i]=false;
	            }
	        }
			return result;
	    }


}
