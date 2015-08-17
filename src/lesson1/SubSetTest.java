package lesson1;
import java.util.*;

/**
 * subset of [1,2,3]
 * @author gjk
 *
 */
public class SubSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>>  result = new ArrayList<List<Integer>>();
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		Collections.sort(input);
    	List<Integer> subset = new ArrayList<Integer>();
    	
    	//subsetHelper(result, input, 0 ,subset);
    	subsetHelper(result, input ,subset);

    	for(List<Integer> l : result){
    		System.out.println(l);
    	}
	}

	//method 1, use a start position index, increase it before passing
    public static void subsetHelper(List<List<Integer>>  result, List<Integer> input, int startPosition, List<Integer> subset ) {
    	
    	result.add(new ArrayList<Integer>(subset)); //remember to copy list

    	for(int i = startPosition; i < input.size(); i++){
    		subset.add(input.get(i));
    		subsetHelper(result, input, i+1, subset);  //put i+1, not position+1, i is temp position
    		subset.remove(subset.size()-1);
    	}
    	
    }
    
	//method 2, remove the first i elements before passing
    public static void subsetHelper(List<List<Integer>>  result, List<Integer> input, List<Integer> subset ) {
    	result.add(new ArrayList<Integer>(subset)); //remember to copy list

    	for(int i = 0; i < input.size(); i++){
    		subset.add(input.get(i));
    		
    		List<Integer> tempInput = new ArrayList<Integer>(input);
    		for(int j = 0; j <= i; j++){
    			tempInput.remove(0); // do not remove(j) !!!!!!!!!!!!!!!!!
    		}
    		
    		subsetHelper(result, tempInput, subset);  
    		subset.remove(subset.size()-1);
    	}
    }


}
