package lesson1;
import java.util.*;

import util.PrintUtil;

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
    		PrintUtil.printList(l);
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
    

}
