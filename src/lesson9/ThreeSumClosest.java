package lesson9;
import java.util.*;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int threeSumClosest(int[] numbers ,int target) {
    	
		return helper(new ArrayList<Integer>(),numbers,0,target,Integer.MAX_VALUE);
    }
    
    private int helper(List<Integer> curr, int[] numbers, int startPos, int target, int closest){
    	
    	if(curr.size() == 3){
    		int sum = curr.get(0)+curr.get(1)+curr.get(2);
    		if(Math.abs(sum-target)<Math.abs(closest-target)){
    			closest = sum;
    		}
    		return closest;
    	}
    	
    	for(int i=startPos;i<numbers.length;i++){
            if(i>startPos && numbers[i]==numbers[i-1]){continue;} //important : i>startPosition, not i>0
            curr.add(numbers[i]);
            int temp = helper(curr,numbers,i+1,target,closest);
    		if(Math.abs(temp-target)<Math.abs(closest-target)){
    			closest = temp;
    		}            
    		curr.remove(curr.size()-1);
    	}
    	
    	return closest;
    }
}
