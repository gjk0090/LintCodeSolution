package other;
import java.util.*;

public class UneatenLeaves {

	public static void main(String[] args) {

		System.out.println(count(10000000, new int[]{2,3,4,5,6,7,8,9,10,11,12,88593,577821}));
		System.out.println(count2(10000000, new int[]{2,3,4,5,6,7,8,9,10,11,12,88593,577821}));

	}

	private static int count(int N, int[] A){
		Set<Integer> set = new HashSet<Integer>(N);
		
		for(int i : A){
			int temp = i;
			while(temp <= N){
				set.add(temp);
				temp = temp + i;
			}
		}
		
		return N-set.size();
	}
	
	private static int count2(int N, int[] A){
		
		// find all subsets
		List<List<Integer>> subsets = helper(new ArrayList<Integer>(), A, 0);
		
		// for all subsets calculate (N / LCM), size : odd + even -
		int eatenSum = 0;
		for(List<Integer> subset : subsets){
			if(subset.size() == 0){continue;} // empty set ignored
			
			long lcm = lcm(subset, N);
			if(lcm>N){continue;}
			
			if(subset.size()%2 == 1){
				eatenSum += N/lcm;
			}else{
				eatenSum -= N/lcm;
			}
		}
		
		// return N-eaten
		return N-eatenSum;
	}

	private static int lcm(List<Integer> subset, int N) {
		
		int lcm = 1;
		
		for(int i : subset){
			lcm = lcm2(lcm,i, N);
			if(lcm>N){return lcm;}
		}
		return lcm;
	}

	private static int lcm(int lcm2, int n) {

		int lcm = 0;
	    int mm = lcm2, nn = n;
	    while (mm != nn) {
	    	while (mm < nn) { mm += lcm2; }
	        while (nn < mm) { nn += n; }
	     }  
	     lcm = mm;
	       
	      return lcm;
	}
	
	private static int lcm2(int i, int j, int N) {

		int big,small;
		if(i>j){
			big = i;
			small = j;
		}else{
			big=j;
			small=i;
		}
		int lcm = big;
		
		while(lcm%small !=0){
			lcm+=big;
			if(lcm>N){return lcm;}

		}
	       
	      return lcm;
	}

	private static List<List<Integer>> helper(List<Integer> subset, int[] A, int startPos) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<Integer>(subset));
		for(int i=startPos; i<A.length; i++){
			subset.add(A[i]);
			subsets.addAll(helper(subset, A, i+1));
			subset.remove(subset.size()-1);
		}
		
		return subsets;
	}
}
