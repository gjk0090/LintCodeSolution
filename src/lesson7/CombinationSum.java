package lesson7;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {

		List<List<Integer>>  result = combinationSum(new int[]{2,3,6,7}, 7);
		for(List<Integer> l : result){
			System.out.println(l);
		}
	}
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> curr = new ArrayList<Integer>();
    	
    	result.addAll(re(candidates, target, curr, 0));
    	
		return result;
    }
	private static List<List<Integer>> re(int[] candidates, int target, List<Integer> curr, int sum) {
    	List<List<Integer>> result = new ArrayList<>();

    	if(sum>target){
    		return result;
    	}
    	
    	if(sum==target){
    		result.add(new ArrayList<Integer>(curr));
    		return result;
    	}
    	
		for(int i=0; i<candidates.length; i++){
			if(curr.size() == 0 || candidates[i] >= curr.get(curr.size()-1)){ //ascending order, avoid duplicate solutions
	    		curr.add(candidates[i]);
	    		result.addAll(re(candidates, target, curr, sum+candidates[i]));
	    		curr.remove(curr.size()-1);
			}
    	}		
		
		return result;
	}
}
