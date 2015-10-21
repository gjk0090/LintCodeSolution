package lesson9;

import java.util.*;

public class KSum {

	public static void main(String[] args) {

		System.out.println(kSum(new int[]{1,3,4,5,8,10,11,12,14,17,20,22,24,25,28,30,31,34,35,37,38,40,42,44,45,48,51,54,56,59,60,61,63,66}, 24, 842));
	}

	public static int kSum(int numbers[], int k, int target) {
		if (numbers.length < k) {
			return 0;
		}
		Arrays.sort(numbers);
		return helper(new ArrayList<Integer>(), numbers, 0, target, k).size();
	}

	private static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> curr, int[] numbers, int startPosition, int target,
			int k) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (curr.size() == k) {
			int sum = 0;
			for (int i : curr) {
				sum += i;
			}
			if (sum == target) {
				result.add(new ArrayList<Integer>(curr));
			}
			return result;
		}

		for (int i = startPosition; i < numbers.length; i++) {
			if (i > startPosition && numbers[i] == numbers[i - 1]) {
				continue;
			}
			curr.add(numbers[i]);
			result.addAll(helper(curr, numbers, i + 1, target, k));
			curr.remove(curr.size() - 1);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
    public int kSum2(int numbers[], int k, int target) {
        if(numbers.length<k){return 0;}
        Arrays.sort(numbers);
        return helper2(new ArrayList<Integer>(),numbers,0,target,k);
    }
    
    private int helper2(ArrayList<Integer> curr, int[] numbers, int startPosition, int target, int k){
        
        int result = 0;
        if(curr.size()==k){
            int sum=0;
            for(int i : curr){sum+=i;}
            if(sum==target){
                result++;
            }
            return result;
        }
        
        
        for(int i=startPosition;i<numbers.length;i++){
            if(i>startPosition && numbers[i]==numbers[i-1]){continue;}
            curr.add(numbers[i]);
            result+=helper2(curr,numbers,i+1,target,k);
            curr.remove(curr.size()-1);
        }
        return result;    
        
    }
}
