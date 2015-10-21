package lesson9;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        if(numbers.length<3){return null;}
        Arrays.sort(numbers);
        return helper(new ArrayList<Integer>(),numbers,0);
    }
    
    private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> curr, int[] numbers, int startPosition){
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(curr.size()==3){
            if(curr.get(0)+curr.get(1)+curr.get(2)==0){
                result.add(new ArrayList<Integer>(curr));
            }
            return result;
        }
        
        
        for(int i=startPosition;i<numbers.length;i++){
            if(i>startPosition && numbers[i]==numbers[i-1]){continue;} //important : i>startPosition, not i>0
            curr.add(numbers[i]);
            result.addAll(helper(curr,numbers,i+1));
            curr.remove(curr.size()-1);
        }
        return result;
        
    }
}
