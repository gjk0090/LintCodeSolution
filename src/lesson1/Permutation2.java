package lesson1;

import java.util.ArrayList;
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
	    		System.out.println(permutation);
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

}
