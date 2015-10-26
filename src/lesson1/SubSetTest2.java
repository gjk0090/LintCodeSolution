package lesson1;
import java.util.*;



/**
 * subset of [1,2,2]
 * @author gjk
 *
 */
public class SubSetTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>>  result = new ArrayList<List<Integer>>();
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(2);
		Collections.sort(input);
    	List<Integer> subset = new ArrayList<Integer>();
    	
    	subsetHelper(result, input, 0 ,subset);

    	for(List<Integer> l : result){
    		System.out.println(l);
    	}
	}

    public static void subsetHelper(List<List<Integer>>  result, List<Integer> input, int startPosition, List<Integer> subset ) {
    	
    	result.add(new ArrayList<Integer>(subset)); //remember to copy list

    	for(int i = startPosition; i < input.size(); i++){
    	    if(i > startPosition && input.get(i) == input.get(i-1)){
    	    }else{
    	    	subset.add(input.get(i));
    	    	subsetHelper(result, input, i+1, subset); 
    	    	subset.remove(subset.size()-1);
    	    }
    	}
    	
    }
    
    
    
    
    //array version
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return re(new ArrayList<>(), nums, 0);
    }
    
    private List<List<Integer>> re(List<Integer> subset, int[] nums, int startPos){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(subset));
        
        for(int i=startPos; i<nums.length; i++){
            if(!(i>startPos && nums[i]==nums[i-1])){
                subset.add(nums[i]);
                result.addAll(re(subset,nums,i+1));
                subset.remove(subset.size()-1);
            }
        }
        return result;
    }

}
