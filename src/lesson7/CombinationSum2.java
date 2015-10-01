package lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {

		List<List<Integer>>  result = combinationSum2(new int[]{10,1,6,7,2,1,5}, 8);
		for(List<Integer> l : result){
			System.out.println(l);
		}
	}
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
    	Arrays.sort(num);
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> curr = new ArrayList<Integer>();
    	    	
		result.addAll(re(num, target, curr, 0 , 0));
    	
		return result;
	}
	private static List<List<Integer>> re(int[] candidates, int target, List<Integer> curr, int startPos, int sum) {
    	List<List<Integer>> result = new ArrayList<>();
    	if(sum>target){
    		return result;
    	}
    	
    	if(sum==target){
    		result.add(new ArrayList<Integer>(curr));
    		return result;
    	}
    	
    	for(int i=startPos; i<candidates.length; i++){
    		if(i==startPos || candidates[i] != candidates[i-1]){
    			curr.add(candidates[i]);
	    		result.addAll(re(candidates, target, curr, i+1, sum+candidates[i]));
	    		curr.remove(curr.size()-1);
    		}
    	}
    	
		return result;
	}

}
