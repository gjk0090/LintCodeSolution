package lesson7;
import java.util.*;
public class KSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        return helper(new ArrayList<Integer>(),A,0,k,target);
    }
    
    private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> curr, int[] A, int startPos, int k, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(curr.size()==k){
            int sum = 0;
            for(int i : curr){
                sum += i;
            }
            if(sum == target){
                result.add(new ArrayList<Integer>(curr));
            }
            return result;
        }
        
        for(int i=startPos; i<A.length; i++){
            curr.add(A[i]);
            result.addAll(helper(curr,A,i+1,k,target));
            curr.remove(curr.size()-1);
        }
        
        return result;
    }
}
