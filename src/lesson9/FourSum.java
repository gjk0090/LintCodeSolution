package lesson9;

import java.util.*;

public class FourSum {

	public static void main(String[] args){
		
	}
	
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        if(numbers.length<4){return new ArrayList<ArrayList<Integer>>();}
        Arrays.sort(numbers);
        return helper(new ArrayList<Integer>(),numbers,0,target);
    }
    
    private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> curr, int[] numbers, int startPosition, int target){
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(curr.size()==4){
            if(curr.get(0)+curr.get(1)+curr.get(2)+curr.get(3)==target){
                result.add(new ArrayList<Integer>(curr));
            }
            return result;
        }
        
        
        for(int i=startPosition;i<numbers.length;i++){
            if(i>startPosition && numbers[i]==numbers[i-1]){continue;}
            curr.add(numbers[i]);
            result.addAll(helper(curr,numbers,i+1,target));
            curr.remove(curr.size()-1);
        }
        return result;
      }
}
